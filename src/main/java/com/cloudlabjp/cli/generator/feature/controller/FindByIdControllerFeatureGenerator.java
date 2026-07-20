package com.cloudlabjp.cli.generator.feature.controller;

import com.cloudlabjp.cli.generator.factory.method.FindByIdControllerMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class FindByIdControllerFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "findById",
                FindByIdControllerMethodFactory.build(context.entityName())
        );

    }

}