package com.cloudlabjp.cli.generator.feature.controller;

import com.cloudlabjp.cli.generator.factory.method.FindAllControllerMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class FindAllControllerFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "findAll",
                FindAllControllerMethodFactory.build(context.entityName())
        );

    }

}