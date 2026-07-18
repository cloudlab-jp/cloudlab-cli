package com.cloudlabjp.cli.generator.feature.update;

import com.cloudlabjp.cli.generator.factory.method.UpdateMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import java.nio.file.Path;

public class UpdateFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
    public void generate(Path serviceFile,
                         String entityName) {

        addMethod(
                serviceFile,
                "update",
                UpdateMethodFactory.build(entityName)
        );

    }

}