package com.cloudlabjp.cli.generator.feature.delete;

import com.cloudlabjp.cli.generator.factory.method.DeleteMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import java.nio.file.Path;

public class DeleteFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
    public void generate(Path serviceFile,
                         String entityName) {

        addMethod(
                serviceFile,
                "delete",
                DeleteMethodFactory.build(entityName)
        );

    }

}