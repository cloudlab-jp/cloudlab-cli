package com.cloudlabjp.cli.generator.pipeline;

public final class PipelineFactory {

    private PipelineFactory() {
    }

    public static GeneratorPipeline entity() {

        return new GeneratorPipeline()

                .add(new EntityJpaStep());

    }

    public static GeneratorPipeline service() {

        return new GeneratorPipeline();

    }

    public static GeneratorPipeline mapper() {

        return new GeneratorPipeline();

    }

}