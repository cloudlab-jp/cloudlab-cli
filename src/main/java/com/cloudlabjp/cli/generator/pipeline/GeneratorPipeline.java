package com.cloudlabjp.cli.generator.pipeline;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GeneratorPipeline {

    private final List<GeneratorStep> steps =
            new ArrayList<>();

    public GeneratorPipeline add(GeneratorStep step) {

        steps.add(step);

        return this;

    }

    public void execute(GenerationContext context) {

        for (GeneratorStep step : steps) {

            step.execute(context);

        }

    }

}