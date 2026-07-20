package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.generator.feature.create.CreateFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.delete.DeleteFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.find.FindAllFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.find.FindByIdFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.update.UpdateFeatureGenerator;
import com.cloudlabjp.cli.generator.pipeline.GenerationContext;

import java.util.List;

public class ServiceFeatureGenerator
        extends CompositeFeatureGenerator {

    public ServiceFeatureGenerator() {

        super(

                List.of(

                        new CreateFeatureGenerator(),

                        new UpdateFeatureGenerator(),

                        new DeleteFeatureGenerator(),

                        new FindByIdFeatureGenerator(),

                        new FindAllFeatureGenerator()

                )

        );

    }

    @Override
    public void generate(
            GenerationContext context
    ) {

        super.generate(context);

    }

}