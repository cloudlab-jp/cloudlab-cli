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

        if (projectRoot == null) {
            return detect();
        }

        Path sourceRoot = projectRoot
                .resolve("src")
                .resolve("main")
                .resolve("java");

        Path applicationClass =
                applicationFinder.find(sourceRoot);

        String basePackage =
                packageExtractor.extract(applicationClass);

        return new ProjectInfo(
                projectRoot,
                sourceRoot,
                basePackage
        );

    }

}