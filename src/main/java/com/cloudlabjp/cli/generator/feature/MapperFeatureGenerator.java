package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.generator.feature.mapper.ToEntityFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.mapper.ToResponseFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.mapper.UpdateMapperFeatureGenerator;

import java.util.List;

public class MapperFeatureGenerator extends CompositeFeatureGenerator {

    public MapperFeatureGenerator() {

        super(

                List.of(

                        new ToEntityFeatureGenerator(),

                        new ToResponseFeatureGenerator(),

                        new UpdateMapperFeatureGenerator()

                )

        );

    }

}