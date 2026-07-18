package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.generator.feature.controller.*;

import java.util.List;

public class ControllerFeatureGenerator
        extends CompositeFeatureGenerator {

    public ControllerFeatureGenerator() {

        super(

                List.of(

                        new CreateControllerFeatureGenerator(),

                        new UpdateControllerFeatureGenerator(),

                        new DeleteControllerFeatureGenerator(),

                        new FindByIdControllerFeatureGenerator(),

                        new FindAllControllerFeatureGenerator()

                )

        );

    }

}