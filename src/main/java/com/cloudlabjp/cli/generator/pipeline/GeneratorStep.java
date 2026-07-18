package com.cloudlabjp.cli.generator.pipeline;

public interface GeneratorStep {

    void execute(GenerationContext context);

}