package com.cloudlabjp.cli.generator.feature.mapper;

import com.cloudlabjp.cli.generator.factory.method.UpdateMapperMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;
import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class UpdateMapperFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
    public void generate(
            GenerationContext context
    ) {

        addMethod(

                context.file(),

                "update",

                UpdateMapperMethodFactory.build(

                        context.entityName(),

                        context.fields()

                )

        );

    }

}