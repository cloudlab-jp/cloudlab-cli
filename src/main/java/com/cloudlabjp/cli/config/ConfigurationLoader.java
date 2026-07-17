package com.cloudlabjp.cli.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigurationLoader {

    public Properties load(Path projectRoot) {

        Properties properties = new Properties();

        if (projectRoot == null) {
            return properties;
        }

        Path configFile = projectRoot.resolve("cloudlab.properties");

        if (!Files.exists(configFile)) {
            return properties;
        }

        try (InputStream input = Files.newInputStream(configFile)) {

            properties.load(input);

            return properties;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load cloudlab.properties.",
                    e
            );

        }

    }

}