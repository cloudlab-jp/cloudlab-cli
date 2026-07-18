package com.cloudlabjp.cli.generator.test;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;

import java.util.List;
import java.util.Map;

public class ServiceTestFileFactory
        implements TestFileFactory {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    @Override
    public List<GeneratedFile> create(

            ProjectInfo project,

            String module,

            String entity

    ) {

        Map<String, String> variables =
                Map.of(

                        "basePackage",
                        project.basePackage(),

                        "module",
                        module,

                        "className",
                        entity

                );

        return List.of(

                new GeneratedFile(

                        "application/service/" +
                                entity +
                                "ServiceTest.java",

                        templateEngine.render(

                                "service-test.java.tpl",

                                variables

                        )

                )

        );

    }

}