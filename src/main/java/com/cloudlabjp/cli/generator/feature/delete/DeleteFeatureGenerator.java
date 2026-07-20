package com.cloudlabjp.cli.generator.feature.delete;

import com.cloudlabjp.cli.generator.factory.method.DeleteMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

public class DeleteFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
public void generate(GenerationContext context) {

        addMethod(
                context.file(),
                "delete",
                DeleteMethodFactory.build(context.entityName())
        );

    }

}