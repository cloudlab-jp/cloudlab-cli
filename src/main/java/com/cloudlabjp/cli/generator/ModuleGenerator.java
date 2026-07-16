package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.JavaTemplates;
import com.cloudlabjp.cli.template.ModuleTemplate;
import com.cloudlabjp.cli.template.ModuleTemplates;
import com.cloudlabjp.cli.util.ConsolePrinter;
import com.cloudlabjp.cli.util.FileSystemUtils;
import com.cloudlabjp.cli.util.StringUtils;

import java.io.IOException;
import java.nio.file.Path;

public class ModuleGenerator {

    public void generate(ProjectInfo project, String moduleName) {

        ModuleTemplate template = ModuleTemplates.springModule();

        Path modulePath = project.sourceRoot()
                .resolve(project.basePackage().replace(".", "/"))
                .resolve("modules")
                .resolve(moduleName);

        String className = StringUtils.capitalize(moduleName);

        ConsolePrinter.info("Location: " + modulePath);
        ConsolePrinter.info("");

        try {

            createDirectories(template, modulePath);

            createGitkeepFiles(template, modulePath);

            createJavaFiles(project, moduleName, className, modulePath);

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
                                 String className,
                                 Path modulePath) throws IOException {

        FileGenerator.createFile(
                modulePath.resolve("application/service/" + className + "Service.java"),
                JavaTemplates.service(project.basePackage(), moduleName)
        );

        FileGenerator.createFile(
                modulePath.resolve("domain/model/" + className + ".java"),
                JavaTemplates.entity(project.basePackage(), moduleName)
        );

        FileGenerator.createFile(
                modulePath.resolve("domain/repository/" + className + "Repository.java"),
                JavaTemplates.repository(project.basePackage(), moduleName)
        );

        FileGenerator.createFile(
                modulePath.resolve("infrastructure/controller/" + className + "Controller.java"),
                JavaTemplates.controller(project.basePackage(), moduleName)
        );

    }

}