package com.cloudlabjp.cli.command;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.nio.file.Path;

@Command(
        name = "cloudlab",
        mixinStandardHelpOptions = true,
        version = "0.1.0",
        description = "CloudLab CLI",
        subcommands = {
                ModuleCommand.class,
                EntityCommand.class,
                AstCommand.class
        }
)
public class RootCommand implements Runnable {

    @Option(
            names = {"-p", "--project"},
            description = "Spring Boot project directory"
    )
    private Path project;

    public Path getProject() {
        return project;
    }

    @Override
    public void run() {
        System.out.println("""

                CloudLab CLI

                Use --help to see available commands.
                """);
    }

}