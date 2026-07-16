package com.cloudlabjp.cli.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class SpringBootApplicationFinder {

    public Path find(Path sourceRoot) {

        try (Stream<Path> paths = Files.walk(sourceRoot)) {

            return paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith("Application.java"))
                    .filter(this::isSpringBootApplication)
                    .findFirst()
                    .orElseThrow(() ->
                            new ProjectException("Spring Boot application class not found."));

        } catch (IOException e) {

            throw new RuntimeException("Unable to inspect source directory.", e);

        }

    }

    private boolean isSpringBootApplication(Path file) {

        try (Stream<String> lines = Files.lines(file)) {

            return lines
                    .map(String::trim)
                    .anyMatch(line -> line.startsWith("@SpringBootApplication"));

        } catch (IOException e) {

            return false;

        }

    }

}