package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.nio.file.Path;
import java.util.List;

public class FeatureExecutor {

    private final ServiceFeatureExecutor serviceExecutor =
            new ServiceFeatureExecutor();

    private final MapperFeatureExecutor mapperExecutor =
            new MapperFeatureExecutor();

    private final ControllerFeatureExecutor controllerExecutor =
            new ControllerFeatureExecutor();

    public void execute(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields,
            Path modulePath
    ) {

        serviceExecutor.execute(
                project,
                module,
                entity,
                fields,
                modulePath
        );

        mapperExecutor.execute(
                project,
                module,
                entity,
                fields,
                modulePath
        );

        controllerExecutor.execute(
                project,
                module,
                entity,
                fields,
                modulePath
        );

    }

}