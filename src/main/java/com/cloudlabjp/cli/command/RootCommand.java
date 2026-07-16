package com.cloudlabjp.cli.command;

import picocli.CommandLine.Command;

@Command(
        name = "cloudlab",
        mixinStandardHelpOptions = true,
        version = "0.1.0",
        description = "CloudLab CLI",
        subcommands = {
                ModuleCommand.class
        }
)
public class RootCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("""
                
                CloudLab CLI
                
                Use --help to see available commands.
                """);
    }

}