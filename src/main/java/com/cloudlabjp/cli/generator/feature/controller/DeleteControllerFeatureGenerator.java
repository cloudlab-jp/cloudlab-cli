package com.cloudlabjp.cli.generator.feature.controller;

import com.cloudlabjp.cli.generator.factory.method.DeleteControllerMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class DeleteControllerFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "delete",
                DeleteControllerMethodFactory.build()
        );

    }

}