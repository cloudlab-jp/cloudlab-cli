package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ModuleTemplate;
import com.cloudlabjp.cli.template.ModuleTemplates;
import com.cloudlabjp.cli.util.ConsolePrinter;
import com.cloudlabjp.cli.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ModuleGenerator {

    private final JavaFileFactory javaFileFactory = new JavaFileFactory();

    public void generate(ProjectInfo project, String moduleName) {

        ModuleTemplate template = ModuleTemplates.springModule();

        Path modulePath = project.sourceRoot()
                .resolve(project.basePackage().replace(".", "/"))
                .resolve("modules")
                .resolve(moduleName);

        ConsolePrinter.info("Location: " + modulePath);
        ConsolePrinter.info("");

        try {

            createDirectories(template, modulePath);

            createGitkeepFiles(template, modulePath);

            createJavaFiles(project, moduleName, modulePath);

        } catch (IOException e) {

            throw new RuntimeException("Unable to generate module.", e);

        }

    }

    private void createDirectories(ModuleTemplate template,
                                   Path modulePath) throws IOException {

        for (String directory : template.directories()) {

            Path folder = modulePath.resolve(directory);

            FileSystemUtils.createDirectory(folder);

            ConsolePrinter.success(directory);

        }

    }

    private void createGitkeepFiles(ModuleTemplate template,
                                    Path modulePath) throws IOException {

        for (String file : template.files()) {

            Path path = modulePath.resolve(file);

            FileSystemUtils.createFile(path);

            ConsolePrinter.success(file);

        }

    }

    private void createJavaFiles(ProjectInfo project,
                                 String moduleName,
                                 Path modulePath) {

        List<GeneratedFile> generatedFiles =
                javaFileFactory.create(project, moduleName);

        for (GeneratedFile file : generatedFiles) {

            FileGenerator.createFile(
                    modulePath.resolve(file.relativePath()),
                    file.content()
            );

        }

    }

}