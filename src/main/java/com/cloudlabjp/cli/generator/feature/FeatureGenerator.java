package com.cloudlabjp.cli.generator.feature;

import java.nio.file.Path;

public interface FeatureGenerator {

    void generate(Path file,
                  String entityName);

}