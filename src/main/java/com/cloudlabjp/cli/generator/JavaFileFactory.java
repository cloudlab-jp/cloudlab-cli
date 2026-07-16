package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;
import com.cloudlabjp.cli.util.StringUtils;

import java.util.List;
import java.util.Map;

public class JavaFileFactory {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    public List<GeneratedFile> create(ProjectInfo project,
                                      String module) {

        String className = StringUtils.capitalize(module);

        Map<String, String> variables = Map.of(
                "basePackage", project.basePackage(),
                "module", module,
                "className", className
        );

        return List.of(

                new GeneratedFile(
                        "application/service/" + className + "Service.java",
                        templateEngine.render("service.java.tpl", variables)
                ),

                new GeneratedFile(
                        "domain/model/" + className + ".java",
                        templateEngine.render("entity.java.tpl", variables)
                ),

                new GeneratedFile(
                        "domain/repository/" + className + "Repository.java",
                        templateEngine.render("repository.java.tpl", variables)
                ),

                new GeneratedFile(
                        "infrastructure/controller/" + className + "Controller.java",
                        templateEngine.render("controller.java.tpl", variables)
                )

        );

    }

}