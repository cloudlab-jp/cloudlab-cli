package com.cloudlabjp.cli.service;

import com.cloudlabjp.cli.generator.FileGenerator;
import com.cloudlabjp.cli.template.JavaTemplates;
import com.cloudlabjp.cli.template.ModuleTemplate;
import com.cloudlabjp.cli.template.ModuleTemplates;
import com.cloudlabjp.cli.util.ConsolePrinter;
import com.cloudlabjp.cli.util.FileSystemUtils;
import com.cloudlabjp.cli.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeneratorService {

    public void createModule(String moduleName) {

        ModuleTemplate template = ModuleTemplates.springModule();

        Path base = Path.of(moduleName);

        String className = StringUtils.capitalize(moduleName);

        ConsolePrinter.info("");
        ConsolePrinter.info("Creating module " + moduleName + "...");
        ConsolePrinter.info("");

        try {

            // Crear carpetas
            for (String directory : template.directories()) {

                Path folder = base.resolve(directory);

                FileSystemUtils.createDirectory(folder);

                ConsolePrinter.success(directory);

            }

            // Crear .gitkeep
            for (String file : template.files()) {

                Path path = base.resolve(file);

                FileSystemUtils.createFile(path);

                ConsolePrinter.success(file);

            }

            // Crear clases Java
            FileGenerator.createFile(
                    base.resolve("application/service/" + className + "Service.java"),
                    JavaTemplates.service(moduleName)
            );

            FileGenerator.createFile(
                    base.resolve("domain/model/" + className + ".java"),
                    JavaTemplates.entity(moduleName)
            );

            FileGenerator.createFile(
                    base.resolve("domain/repository/" + className + "Repository.java"),
                    JavaTemplates.repository(moduleName)
            );

            FileGenerator.createFile(
                    base.resolve("infrastructure/controller/" + className + "Controller.java"),
                    JavaTemplates.controller(moduleName)
            );

            ConsolePrinter.info("");
            ConsolePrinter.success("Done.");

        } catch (IOException e) {
            throw new RuntimeException("Unable to create module structure.", e);
        }

    }

}