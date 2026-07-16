package com.cloudlabjp.cli.project;

import java.nio.file.Files;
import java.nio.file.Path;

public class ProjectDetector {

    private final SpringBootApplicationFinder applicationFinder;
    private final PackageExtractor packageExtractor;

    public ProjectDetector() {
        this(
                new SpringBootApplicationFinder(),
                new PackageExtractor()
        );
    }

    public ProjectDetector(SpringBootApplicationFinder applicationFinder,
                           PackageExtractor packageExtractor) {
        this.applicationFinder = applicationFinder;
        this.packageExtractor = packageExtractor;
    }

    public ProjectInfo detect() {
        return detect(Path.of("").toAbsolutePath());
    }

    public ProjectInfo detect(Path projectRoot) {

        Path pom = projectRoot.resolve("pom.xml");

        if (!Files.exists(pom)) {
            throw new ProjectException(
                    "pom.xml not found. Current directory is not a Maven project."
            );
        }

        Path sourceRoot = projectRoot.resolve("src/main/java");

        if (!Files.exists(sourceRoot)) {
            throw new ProjectException(
                    "src/main/java not found."
            );
        }

        Path applicationClass = applicationFinder.find(sourceRoot);

        String basePackage = packageExtractor.extract(applicationClass);

        return new ProjectInfo(
                projectRoot,
                sourceRoot,
                basePackage
        );

    }

}