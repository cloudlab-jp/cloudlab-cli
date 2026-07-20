package com.cloudlabjp.cli.generator.feature.find;

import com.cloudlabjp.cli.generator.factory.method.FindByIdMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class FindByIdFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "findById",
                FindByIdMethodFactory.build(context.entityName())
        );

    }

}