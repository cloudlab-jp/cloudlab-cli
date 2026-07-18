package com.cloudlabjp.cli.generator.service;

import com.cloudlabjp.cli.config.GeneratorConfiguration;
import com.cloudlabjp.cli.generator.builder.LombokBuilder;
import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;
import com.cloudlabjp.cli.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceFileFactory {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    private final LombokBuilder lombokBuilder =
            new LombokBuilder();

    public List<GeneratedFile> create(ProjectInfo project,
                                      String module,
                                      String entity) {

        GeneratorConfiguration configuration =
                new GeneratorConfiguration(
                        project.projectRoot()
                );

        String className =
                StringUtils.capitalize(entity);

        Map<String, String> variables = new HashMap<>();

        variables.put("basePackage", project.basePackage());
        variables.put("module", module);
        variables.put("className", className);

        variables.put("imports", "");
        variables.put("annotations", "");
        variables.put("constructor", "");

        switch (configuration.entityStyle()) {

            case PLAIN -> {
                // Por ahora no hacemos nada
            }

            case LOMBOK -> {

                variables.put(
                        "imports",
                        lombokBuilder.buildServiceImports()
                );

                variables.put(
                        "annotations",
                        lombokBuilder.buildServiceAnnotations()
                );

            }

        }

        return List.of(

                new GeneratedFile(
                        "application/service/" +
                                className +
                                "Service.java",

                        templateEngine.render(
                                "service.java.tpl",
                                variables
                        )
                )

        );

    }

}