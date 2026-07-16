package com.cloudlabjp.cli;

import com.cloudlabjp.cli.command.RootCommand;
import picocli.CommandLine;

public class CloudLabCliApplication {

    public static void main(String[] args) {

        int exitCode = new CommandLine(new RootCommand()).execute(args);

        System.exit(exitCode);

    }

}