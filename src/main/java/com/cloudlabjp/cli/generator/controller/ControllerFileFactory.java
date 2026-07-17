package com.cloudlabjp.cli.generator.controller;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;
import com.cloudlabjp.cli.util.StringUtils;

import java.util.List;
import java.util.Map;

public class ControllerFileFactory {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    public List<GeneratedFile> create(ProjectInfo project,
                                      String module,
                                      String entity) {

        String className = StringUtils.capitalize(entity);

        Map<String, String> variables = Map.of(
                "basePackage", project.basePackage(),
                "module", module,
                "className", className
        );

        return List.of(

                new GeneratedFile(
                        "infrastructure/controller/"
                                + className
                                + "Controller.java",

                        templateEngine.render(
                                "controller.java.tpl",
                                variables
                        )
                )

        );

    }

}