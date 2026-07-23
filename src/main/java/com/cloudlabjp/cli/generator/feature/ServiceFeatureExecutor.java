package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.editor.configurer.ServiceConfigurer;
import com.cloudlabjp.cli.generator.pipeline.GenerationContext;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.nio.file.Path;
import java.util.List;

public class ServiceFeatureExecutor {

    private final ServiceConfigurer configurer =
            new ServiceConfigurer();

    private final ServiceFeatureGenerator generator =
            new ServiceFeatureGenerator();

    public void execute(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields,
            Path modulePath
    ) {

        Path file =
                modulePath.resolve(
                        "application/service/"
                                + entity
                                + "Service.java"
                );

        configurer.configure(
                file,
                project.basePackage(),
                module,
                entity
        );

        generator.generate(

                new GenerationContext(
                        project,
                        module,
                        file,
                        entity,
                        fields
                )

        );

    }

}