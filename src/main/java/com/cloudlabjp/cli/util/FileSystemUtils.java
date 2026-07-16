package com.cloudlabjp.cli.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileSystemUtils {

    private FileSystemUtils() {
    }

    public static void createDirectory(Path path) throws IOException {
        Files.createDirectories(path);
    }

    public static void createFile(Path path) throws IOException {

        if (Files.notExists(path)) {
            Files.createFile(path);
        }

    }

}
