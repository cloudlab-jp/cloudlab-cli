package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.controller.ControllerFileFactory;
import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.generator.repository.RepositoryFileFactory;
import com.cloudlabjp.cli.generator.service.ServiceFileFactory;
import com.cloudlabjp.cli.generator.test.TestFileFactoryRegistry;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

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

    private final TestFileFactoryRegistry testFactory =
            new TestFileFactoryRegistry();

    private final GenerationOrchestrator orchestrator =
            new GenerationOrchestrator();

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

        files.addAll(
                testFactory.create(
                        project,
                        moduleName,
                        entityName
                )
        );

        orchestrator.generate(
                project,
                moduleName,
                entityName,
                fields,
                modulePath,
                files
        );

    }

}