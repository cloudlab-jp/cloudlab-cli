package com.cloudlabjp.cli.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileGenerator {

    private FileGenerator() {
    }

    public static void createFile(Path path, String content) {

        try {

            Files.createDirectories(path.getParent());

            if (!Files.exists(path)) {
                Files.writeString(path, content);
            }

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to create file: " + path,
                    e
            );

        }

    }

}