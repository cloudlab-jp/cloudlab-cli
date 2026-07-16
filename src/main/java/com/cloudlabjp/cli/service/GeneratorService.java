package com.cloudlabjp.cli.service;

import com.cloudlabjp.cli.generator.ModuleGenerator;
import com.cloudlabjp.cli.project.ProjectDetector;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.util.ConsolePrinter;

import java.nio.file.Path;

public class GeneratorService {

    private final ProjectDetector detector = new ProjectDetector();

    private final ModuleGenerator moduleGenerator = new ModuleGenerator();

    public void createModule(String moduleName) {

        ProjectInfo project = detector.detect(
                Path.of("../novacommerce/backend") // temporal mientras desarrollamos
        );

        ConsolePrinter.info("");
        ConsolePrinter.info("Creating module: " + moduleName);

        moduleGenerator.generate(project, moduleName);

        ConsolePrinter.info("");
        ConsolePrinter.success("Done.");

    }

}