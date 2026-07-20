package com.cloudlabjp.cli.generator.feature.find;

import com.cloudlabjp.cli.generator.factory.method.FindAllMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class FindAllFeatureGenerator extends BaseFeatureGenerator implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "findAll",
                FindAllMethodFactory.build(context.entityName())
        );

    }

}