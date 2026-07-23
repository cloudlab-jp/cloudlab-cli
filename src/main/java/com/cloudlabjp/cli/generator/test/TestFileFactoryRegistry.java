package com.cloudlabjp.cli.generator.test;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.util.List;

public class TestFileFactoryRegistry {

    private final List<TestFileFactory> factories =
            List.of(
                    new ServiceTestFileFactory()
            );

    public List<GeneratedFile> create(
            ProjectInfo project,
            String module,
            String entity
    ) {

        return factories.stream()
                .flatMap(factory ->
                        factory.create(
                                project,
                                module,
                                entity
                        ).stream()
                )
                .toList();

    }

}