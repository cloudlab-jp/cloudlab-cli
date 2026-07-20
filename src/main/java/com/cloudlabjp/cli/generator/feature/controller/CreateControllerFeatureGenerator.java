package com.cloudlabjp.cli.generator.feature.controller;

import com.cloudlabjp.cli.generator.factory.method.CreateControllerMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class CreateControllerFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "create",
                CreateControllerMethodFactory.build(context.entityName())
        );

    }

}