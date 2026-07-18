package com.cloudlabjp.cli.generator.feature.mapper;

import com.cloudlabjp.cli.generator.factory.method.UpdateMapperMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import java.nio.file.Path;

public class UpdateMapperFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
    public void generate(Path mapperFile,
                         String entityName) {

        addMethod(
                mapperFile,
                "update",
                UpdateMapperMethodFactory.build(entityName)
        );

    }

}