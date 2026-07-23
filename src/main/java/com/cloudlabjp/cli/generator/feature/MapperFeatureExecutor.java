package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.nio.file.Path;
import java.util.List;

public class MapperFeatureExecutor {

    private final MapperFeatureGenerator generator =
            new MapperFeatureGenerator();

    public void execute(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields,
            Path modulePath
    ) {

        Path file =
                modulePath.resolve(
                        "application/mapper/"
                                + entity
                                + "Mapper.java"
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