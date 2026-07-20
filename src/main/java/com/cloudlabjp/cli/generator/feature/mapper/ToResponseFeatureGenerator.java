package com.cloudlabjp.cli.generator.feature.mapper;

import com.cloudlabjp.cli.generator.factory.method.ResponseMapperMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;
import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class ToResponseFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
    public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "toResponse",
                ResponseMapperMethodFactory.build(
                        context.entityName(),
                        context.fields()
                )
        );

    }

}