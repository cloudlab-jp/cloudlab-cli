package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

import java.util.List;

public class CompositeFeatureGenerator
        implements FeatureGenerator {

    private final List<FeatureGenerator> generators;

    public CompositeFeatureGenerator(
            List<FeatureGenerator> generators
    ) {
        this.generators = generators;
    }

    @Override
    public void generate(
            GenerationContext context
    ) {

        generators.forEach(generator ->
                generator.generate(context));

    }

}