package com.cloudlabjp.cli.generator.test;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.generator.test.body.ServiceTestBodyGenerator;
import com.cloudlabjp.cli.generator.test.imports.ServiceTestImportResolver;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceTestFileFactory
        implements TestFileFactory {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    private final ServiceTestBodyGenerator bodyGenerator =
            new ServiceTestBodyGenerator();

    private final ServiceTestImportResolver importResolver =
            new ServiceTestImportResolver();

    @Override
    public List<GeneratedFile> create(
            ProjectInfo project,
            String module,
            String entity
    ) {

        Map<String, String> variables =
                new HashMap<>();

        variables.put(
                "basePackage",
                project.basePackage()
        );

        variables.put(
                "module",
                module
        );

        variables.put(
                "className",
                entity
        );

        variables.put(
                "imports",
                importResolver.resolve(
                        project.basePackage(),
                        module,
                        entity
                )
        );

        variables.put(
                "tests",
                bodyGenerator.generate()
        );

        return List.of(

                new GeneratedFile(

                        "application/service/"
                                + entity
                                + "ServiceTest.java",

                        templateEngine.render(
                                "service-test.java.tpl",
                                variables
                        )

                )

        );

    }

}