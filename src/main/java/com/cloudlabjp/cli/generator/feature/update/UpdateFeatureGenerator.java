package com.cloudlabjp.cli.generator.feature.update;

import com.cloudlabjp.cli.generator.factory.method.UpdateMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;

import java.nio.file.Path;

public class UpdateFeatureGenerator extends BaseFeatureGenerator {

    public void generate(Path serviceFile,
                         String entityName) {

        addMethod(
                serviceFile,
                "update",
                UpdateMethodFactory.build(entityName)
        );

    }

}