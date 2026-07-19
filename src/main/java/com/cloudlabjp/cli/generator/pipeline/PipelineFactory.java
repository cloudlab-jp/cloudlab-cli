package com.cloudlabjp.cli.generator.pipeline;

public final class PipelineFactory {

    private PipelineFactory() {
    }

    public static GeneratorPipeline entity() {

        return new GeneratorPipeline()

                .add(new EntityJpaStep())

                .add(new RelationshipStep());

    }

    public static GeneratorPipeline repository() {

        return new GeneratorPipeline()

                .add(new RepositoryStep());

    }

    public static GeneratorPipeline service() {

        return new GeneratorPipeline();

    }

    public static GeneratorPipeline mapper() {

        return new GeneratorPipeline();

    }

    public static GeneratorPipeline controller() {

        return new GeneratorPipeline();

    }



}