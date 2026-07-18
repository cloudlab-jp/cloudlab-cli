package com.cloudlabjp.cli.generator.pipeline;

import java.nio.file.Path;

public interface GeneratorStep {

    void execute(Path file);

}