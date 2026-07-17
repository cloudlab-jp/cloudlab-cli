package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
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

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to generate entity.",
                    e
            );

        }

    }

}