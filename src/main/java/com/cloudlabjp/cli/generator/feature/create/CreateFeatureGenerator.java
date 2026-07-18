package com.cloudlabjp.cli.generator.feature.create;

import com.cloudlabjp.cli.generator.factory.method.CreateMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import java.nio.file.Path;

public class CreateFeatureGenerator extends BaseFeatureGenerator implements FeatureGenerator {

    public void generate(Path serviceFile,
                         String entityName) {

        addMethod(
                serviceFile,
                "create",
                CreateMethodFactory.build(entityName)
        );

    }

}