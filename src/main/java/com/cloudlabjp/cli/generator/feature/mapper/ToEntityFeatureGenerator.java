package com.cloudlabjp.cli.generator.feature.mapper;

import com.cloudlabjp.cli.generator.factory.method.CreateMapperMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;
import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class ToEntityFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
    public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "toEntity",
                CreateMapperMethodFactory.build(
                        context.entityName(),
                        context.fields()
                )
        );

    }

}