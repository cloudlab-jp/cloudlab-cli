package com.cloudlabjp.cli.command;

import com.cloudlabjp.cli.service.EntityGeneratorService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
        name = "entity",
        description = "Generate a new domain entity."
)
public class EntityCommand implements Runnable {

    @Parameters(index = "0", description = "Module name")
    private String moduleName;

    @Parameters(index = "1", description = "Entity name")
    private String entityName;

    private final EntityGeneratorService service =
            new EntityGeneratorService();

    @Override
    public void run() {
        service.createEntity(moduleName, entityName);
    }

}