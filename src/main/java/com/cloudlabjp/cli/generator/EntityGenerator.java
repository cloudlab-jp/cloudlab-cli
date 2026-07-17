package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.util.ConsolePrinter;
import com.cloudlabjp.cli.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class EntityGenerator {

    private final EntityFileFactory fileFactory =
            new EntityFileFactory();

    public void generate(ProjectInfo project,
                         String moduleName,
                         String entityName) {

        Path modulePath = project.sourceRoot()
                .resolve(project.basePackage().replace(".", "/"))
                .resolve("modules")
                .resolve(moduleName);

        List<GeneratedFile> files =
                fileFactory.create(
                        project,
                        moduleName,
                        entityName
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