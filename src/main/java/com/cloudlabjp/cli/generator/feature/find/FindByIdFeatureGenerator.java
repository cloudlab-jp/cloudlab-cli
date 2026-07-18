package com.cloudlabjp.cli.generator.feature.find;

import com.cloudlabjp.cli.generator.factory.method.FindByIdMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;

import java.nio.file.Path;

public class FindByIdFeatureGenerator extends BaseFeatureGenerator {

    public void generate(Path serviceFile,
                         String entityName) {

        addMethod(
                serviceFile,
                "findById",
                FindByIdMethodFactory.build(entityName)
        );

    }

}