package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.generator.feature.create.CreateFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.delete.DeleteFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.find.FindAllFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.find.FindByIdFeatureGenerator;
import com.cloudlabjp.cli.generator.feature.update.UpdateFeatureGenerator;

import java.nio.file.Path;

public class ServiceFeatureGenerator {

    private final CreateFeatureGenerator createGenerator =
            new CreateFeatureGenerator();

    private final UpdateFeatureGenerator updateGenerator =
            new UpdateFeatureGenerator();

    private final DeleteFeatureGenerator deleteGenerator =
            new DeleteFeatureGenerator();

    private final FindByIdFeatureGenerator findByIdGenerator =
            new FindByIdFeatureGenerator();

    private final FindAllFeatureGenerator findAllGenerator =
            new FindAllFeatureGenerator();

    public void generate(Path serviceFile,
                         String entityName) {

        createGenerator.generate(
                serviceFile,
                entityName
        );

        updateGenerator.generate(
                serviceFile,
                entityName
        );

        deleteGenerator.generate(
                serviceFile,
                entityName
        );

        findByIdGenerator.generate(
                serviceFile,
                entityName
        );

        findAllGenerator.generate(
                serviceFile,
                entityName
        );

    }

}