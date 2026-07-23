package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.feature.FeatureExecutor;
import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class GenerationOrchestrator {

    private final GeneratedFileWriter fileWriter =
            new GeneratedFileWriter();

    private final PipelineExecutor pipelineExecutor =
            new PipelineExecutor();

    private final FeatureExecutor featureExecutor =
            new FeatureExecutor();

    public void generate(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields,
            Path modulePath,
            List<GeneratedFile> files
    ) {

        try {

            fileWriter.write(
                    modulePath,
                    files
            );

            pipelineExecutor.executeEntity(
                    project,
                    module,
                    entity,
                    fields,
                    modulePath
            );

            pipelineExecutor.executeRepository(
                    project,
                    module,
                    entity,
                    fields,
                    modulePath
            );

            featureExecutor.execute(
                    project,
                    module,
                    entity,
                    fields,
                    modulePath
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to generate entity.",
                    e
            );

        }

    }

}