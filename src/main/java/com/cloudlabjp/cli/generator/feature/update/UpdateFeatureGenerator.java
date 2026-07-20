package com.cloudlabjp.cli.generator.feature.update;

import com.cloudlabjp.cli.generator.factory.method.UpdateMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class UpdateFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "update",
                UpdateMethodFactory.build(context.entityName())
        );

    }

}