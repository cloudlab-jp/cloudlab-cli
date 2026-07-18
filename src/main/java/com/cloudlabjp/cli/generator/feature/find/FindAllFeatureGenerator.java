package com.cloudlabjp.cli.generator.feature.find;

import com.cloudlabjp.cli.generator.factory.method.FindAllMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;

import java.nio.file.Path;

public class FindAllFeatureGenerator extends BaseFeatureGenerator {

    public void generate(Path serviceFile,
                         String entityName) {

        addMethod(
                serviceFile,
                "findAll",
                FindAllMethodFactory.build(entityName)
        );

    }

}