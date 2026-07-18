package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.generator.feature.controller.CreateControllerFeatureGenerator;

import java.util.List;

public class ControllerFeatureGenerator
        extends CompositeFeatureGenerator {

    public ControllerFeatureGenerator() {

        super(

                List.of(

                        new CreateControllerFeatureGenerator()

                )

        );

    }

}