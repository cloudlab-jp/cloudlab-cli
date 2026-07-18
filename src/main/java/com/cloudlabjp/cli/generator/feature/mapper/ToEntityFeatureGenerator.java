package com.cloudlabjp.cli.generator.feature.mapper;

import com.cloudlabjp.cli.generator.factory.method.MapperMethodFactory;
import com.cloudlabjp.cli.generator.feature.BaseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.FeatureGenerator;

import java.nio.file.Path;

public class ToEntityFeatureGenerator
        extends BaseFeatureGenerator
        implements FeatureGenerator {

    @Override
    public void generate(Path mapperFile,
                         String entityName) {

        addMethod(
                mapperFile,
                "toEntity",
                MapperMethodFactory.toEntity(entityName)
        );

    }

}