package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.editor.configurer.ControllerConfigurer;
import com.cloudlabjp.cli.editor.configurer.ServiceConfigurer;
import com.cloudlabjp.cli.generator.controller.ControllerFileFactory;
import com.cloudlabjp.cli.generator.feature.ControllerFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.MapperFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.ServiceFeatureGenerator;
import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.generator.pipeline.EntityJpaStep;
import com.cloudlabjp.cli.generator.pipeline.GenerationContext;
import com.cloudlabjp.cli.generator.pipeline.GeneratorPipeline;
import com.cloudlabjp.cli.generator.pipeline.PipelineFactory;
import com.cloudlabjp.cli.generator.repository.RepositoryFileFactory;
import com.cloudlabjp.cli.generator.service.ServiceFileFactory;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.util.ConsolePrinter;
import com.cloudlabjp.cli.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EntityGenerator {

    private final EntityFileFactory fileFactory =
            new EntityFileFactory();

    private final RepositoryFileFactory repositoryFactory =
            new RepositoryFileFactory();

    private final ServiceFileFactory serviceFactory =
            new ServiceFileFactory();

    private final ControllerFileFactory controllerFactory =
            new ControllerFileFactory();

    private final ServiceFeatureGenerator serviceFeatureGenerator =
            new ServiceFeatureGenerator();

    private final MapperFeatureGenerator mapperFeatureGenerator =
            new MapperFeatureGenerator();

    private final ServiceConfigurer serviceConfigurer =
            new ServiceConfigurer();

    private final ControllerConfigurer controllerConfigurer =
            new ControllerConfigurer();

    private final ControllerFeatureGenerator controllerFeatureGenerator =
            new ControllerFeatureGenerator();

    public void generate(ProjectInfo project,
                         String moduleName,
                         String entityName,
                         List<FieldDefinition> fields) {

        Path modulePath = project.sourceRoot()
                .resolve(project.basePackage().replace(".", "/"))
                .resolve("modules")
                .resolve(moduleName);

        List<GeneratedFile> files = new ArrayList<>();

        files.addAll(
                fileFactory.create(
                        project,
                        moduleName,
                        entityName,
                        fields
                )
        );

        files.addAll(
                repositoryFactory.create(
                        project,
                        moduleName,
                        entityName
                )
        );

        files.addAll(
                serviceFactory.create(
                        project,
                        moduleName,
                        entityName
                )
        );

        files.addAll(
                controllerFactory.create(
                        project,
                        moduleName,
                        entityName
                )
        );

        try {

            for (GeneratedFile file : files) {

                Path output = modulePath.resolve(file.relativePath());

                FileSystemUtils.createDirectory(output.getParent());

                FileGenerator.createFile(
                        output,
                        file.content()
                );

                ConsolePrinter.success(file.relativePath());

            }

            Path entityFile = modulePath.resolve(
                    "domain/model/" + entityName + ".java"
            );

            GenerationContext entityContext =
                    new GenerationContext(
                            project,
                            moduleName,
                            entityFile,
                            entityName,
                            fields
                    );

            PipelineFactory.entity()
                    .execute(entityContext);

            Path repositoryFile = modulePath.resolve(
                    "domain/repository/" + entityName + "Repository.java"
            );

            GenerationContext repositoryContext =
                    new GenerationContext(
                            project,
                            moduleName,
                            repositoryFile,
                            entityName,
                            fields
                    );

            PipelineFactory.repository()
                    .execute(repositoryContext);

            Path serviceFile = modulePath.resolve(
                    "application/service/" + entityName + "Service.java"
            );

            GenerationContext serviceContext =
                    new GenerationContext(
                            project,
                            moduleName,
                            serviceFile,
                            entityName,
                            fields
                    );

            serviceConfigurer.configure(
                    serviceFile,
                    project.basePackage(),
                    moduleName,
                    entityName
            );

            serviceFeatureGenerator.generate(
                    serviceContext
            );

            Path mapperFile = modulePath.resolve(
                    "application/mapper/" + entityName + "Mapper.java"
            );

            GenerationContext mapperContext =
                    new GenerationContext(
                            project,
                            moduleName,
                            mapperFile,
                            entityName,
                            fields
                    );

            mapperFeatureGenerator.generate(
                    mapperContext
            );

            Path controllerFile = modulePath.resolve(
                    "infrastructure/controller/"
                            + entityName
                            + "Controller.java"
            );

            GenerationContext controllerContext =
                    new GenerationContext(
                            project,
                            moduleName,
                            controllerFile,
                            entityName,
                            fields
                    );

            controllerConfigurer.configure(
                    controllerFile,
                    project.basePackage(),
                    moduleName,
                    entityName
            );

            controllerFeatureGenerator.generate(
                    controllerContext
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to generate entity.",
                    e
            );

        }

    }

}