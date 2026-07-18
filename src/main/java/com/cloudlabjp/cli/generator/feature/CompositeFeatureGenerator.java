package com.cloudlabjp.cli.generator.feature;

import java.nio.file.Path;
import java.util.List;

public class CompositeFeatureGenerator implements FeatureGenerator {

    private final List<FeatureGenerator> generators;

    public CompositeFeatureGenerator(List<FeatureGenerator> generators) {
        this.generators = generators;
    }

    @Override
    public void generate(Path file,
                         String entityName) {

        for (FeatureGenerator generator : generators) {

            generator.generate(
                    file,
                    entityName
            );

        }

    }

}