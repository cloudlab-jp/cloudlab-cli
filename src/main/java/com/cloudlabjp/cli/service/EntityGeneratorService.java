package com.cloudlabjp.cli.service;

import com.cloudlabjp.cli.generator.EntityGenerator;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectDetector;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.util.ConsolePrinter;

import java.nio.file.Path;
import java.util.List;

public class EntityGeneratorService {

    private final ProjectDetector detector =
            new ProjectDetector();

    private final EntityGenerator generator =
            new EntityGenerator();

    public void createEntity(Path projectPath,
                             String moduleName,
                             String entityName,
                             List<FieldDefinition> fields) {

        ConsolePrinter.info("");
        ConsolePrinter.info("Creating entity: " + entityName);
        ConsolePrinter.info("Module: " + moduleName);
        ConsolePrinter.info("");

        ProjectInfo project =
                detector.detect(projectPath);

        generator.generate(
                project,
                moduleName,
                entityName,
                fields
        );

        ConsolePrinter.info("");
        ConsolePrinter.success("Done.");

    }

}