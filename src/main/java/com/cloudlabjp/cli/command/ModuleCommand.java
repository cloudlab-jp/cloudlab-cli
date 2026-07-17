package com.cloudlabjp.cli.command;

import com.cloudlabjp.cli.service.GeneratorService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;

@Command(
        name = "module",
        description = "Generate a new module."
)
public class ModuleCommand implements Runnable {

    @Parameters(index = "0", description = "Module name")
    private String moduleName;

    @Option(
            names = {"-p", "--project"},
            description = "Spring Boot project directory"
    )
    private Path project;

    private final GeneratorService service =
            new GeneratorService();

    @Override
    public void run() {

        service.createModule(
                project,
                moduleName
        );

    }

}