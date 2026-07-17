package com.cloudlabjp.cli.command;

import com.cloudlabjp.cli.service.EntityGeneratorService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;

@Command(
        name = "entity",
        description = "Generate a new domain entity."
)
public class EntityCommand implements Runnable {

    @Parameters(index = "0", description = "Module name")
    private String moduleName;

    @Parameters(index = "1", description = "Entity name")
    private String entityName;

    @Option(
            names = {"-p", "--project"},
            description = "Spring Boot project directory"
    )
    private Path project;

    private final EntityGeneratorService service =
            new EntityGeneratorService();

    @Override
    public void run() {

        service.createEntity(
                project,
                moduleName,
                entityName
        );

    }

}