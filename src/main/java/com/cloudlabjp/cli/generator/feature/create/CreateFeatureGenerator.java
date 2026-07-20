package com.cloudlabjp.cli.generator.feature.create;

import com.cloudlabjp.cli.generator.factory.method.CreateMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class CreateFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "create",
                CreateMethodFactory.build(context.entityName())
        );

    }

}