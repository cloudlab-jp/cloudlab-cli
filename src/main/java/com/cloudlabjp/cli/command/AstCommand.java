package com.cloudlabjp.cli.command;

import com.cloudlabjp.cli.generator.feature.create.CreateFeatureGenerator;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.nio.file.Path;
import java.util.List;

@Command(
        name = "ast",
        description = "Inspect a Java source file."
)
public class AstCommand implements Runnable {

    @Option(
            names = "-f",
            required = true,
            description = "Java file"
    )
    private Path file;

    @Override
    public void run() {

        new CreateFeatureGenerator()
                .generate(file);

    }



}