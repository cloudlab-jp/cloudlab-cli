package com.cloudlabjp.cli.service;

import com.cloudlabjp.cli.generator.ModuleGenerator;
import com.cloudlabjp.cli.project.ProjectDetector;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.util.ConsolePrinter;

import java.nio.file.Path;

public class GeneratorService {

    private final ProjectDetector detector =
            new ProjectDetector();

    private final ModuleGenerator generator =
            new ModuleGenerator();

    public void createModule(Path projectPath,
                             String moduleName) {

        ConsolePrinter.info("");
        ConsolePrinter.info("Creating module: " + moduleName);

        ProjectInfo project =
                detector.detect(projectPath);

        generator.generate(project, moduleName);

        ConsolePrinter.info("");
        ConsolePrinter.success("Done.");

    }

}