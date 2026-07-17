package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;
import com.cloudlabjp.cli.util.ConsolePrinter;
import com.cloudlabjp.cli.util.FileSystemUtils;
import com.cloudlabjp.cli.util.StringUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class EntityGenerator {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    public void generate(ProjectInfo project,
                         String moduleName,
                         String entityName) {

        String className = StringUtils.capitalize(entityName);

        Path file = project.sourceRoot()
                .resolve(project.basePackage().replace(".", "/"))
                .resolve("modules")
                .resolve(moduleName)
                .resolve("domain")
                .resolve("model")
                .resolve(className + ".java");

        Map<String, String> variables = Map.of(
                "basePackage", project.basePackage(),
                "module", moduleName,
                "className", className
        );

        try {

            FileSystemUtils.createDirectory(file.getParent());

            FileGenerator.createFile(
                    file,
                    templateEngine.render("entity.java.tpl", variables)
            );

            ConsolePrinter.success(file.toString());

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}