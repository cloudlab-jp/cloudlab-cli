package com.cloudlabjp.cli.command;

import com.cloudlabjp.cli.service.GeneratorService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
        name = "module",
        description = "Creates a new module"
)
public class ModuleCommand implements Runnable {

    @Parameters(index = "0", description = "Module name")
    private String moduleName;

    private final GeneratorService generatorService = new GeneratorService();

    @Override
    public void run() {
        generatorService.createModule(moduleName);
    }

}