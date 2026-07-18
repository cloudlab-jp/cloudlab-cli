package com.cloudlabjp.cli.generator.feature.find;

import com.cloudlabjp.cli.generator.factory.method.FindAllMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import java.nio.file.Path;

public class FindAllFeatureGenerator extends BaseFeatureGenerator implements FeatureGenerator {

    public void generate(Path serviceFile,
                         String entityName) {

        addMethod(
                serviceFile,
                "findAll",
                FindAllMethodFactory.build(entityName)
        );

    }

}