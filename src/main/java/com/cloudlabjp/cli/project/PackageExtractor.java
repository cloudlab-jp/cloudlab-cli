package com.cloudlabjp.cli.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PackageExtractor {

    public String extract(Path javaFile) {

        try (Stream<String> lines = Files.lines(javaFile)) {

            return lines
                    .map(String::trim)
                    .filter(line -> line.startsWith("package "))
                    .findFirst()
                    .map(line -> line
                            .replace("package", "")
                            .replace(";", "")
                            .trim())
                    .orElseThrow(() ->
                            new ProjectException("Package declaration not found."));

        } catch (IOException e) {

            throw new RuntimeException("Unable to extract package.", e);

        }

    }

}