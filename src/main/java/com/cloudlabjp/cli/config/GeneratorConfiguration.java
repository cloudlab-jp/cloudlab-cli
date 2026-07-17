package com.cloudlabjp.cli.config;

import java.nio.file.Path;
import java.util.Properties;

public class GeneratorConfiguration {

    private final Properties properties;

    public GeneratorConfiguration(Path projectRoot) {
        properties = new ConfigurationLoader()
                .load(projectRoot);

    }

    public EntityStyle entityStyle() {

        return EntityStyle.valueOf(
                properties.getProperty(
                        "generator.entity-style",
                        "plain"
                ).toUpperCase()
        );

    }

}