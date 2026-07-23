package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;
import com.cloudlabjp.cli.generator.pipeline.GeneratorPipeline;
import com.cloudlabjp.cli.generator.pipeline.PipelineFactory;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.nio.file.Path;
import java.util.List;

public class PipelineExecutor {

    public void executeEntity(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields,
            Path modulePath
    ) {

        execute(
                project,
                module,
                entity,
                fields,
                modulePath.resolve(
                        "domain/model/" + entity + ".java"
                ),
                PipelineFactory.entity()
        );

    }

    public void executeRepository(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields,
            Path modulePath
    ) {

        execute(
                project,
                module,
                entity,
                fields,
                modulePath.resolve(
                        "domain/repository/" + entity + "Repository.java"
                ),
                PipelineFactory.repository()
        );

    }

    private void execute(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields,
            Path file,
            GeneratorPipeline pipeline
    ) {

        pipeline.execute(

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