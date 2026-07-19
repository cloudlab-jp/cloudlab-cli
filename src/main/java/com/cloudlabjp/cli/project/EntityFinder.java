package com.cloudlabjp.cli.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EntityFinder {

    public Path findEntity(
            ProjectInfo project,
            String entityName
    ) {

        try {

            return Files.walk(project.sourceRoot())

                    .filter(Files::isRegularFile)

                    .filter(path ->
                            path.getFileName()
                                    .toString()
                                    .equals(entityName + ".java")
                    )

                    .findFirst()

                    .orElseThrow(() ->
                            new ProjectException(
                                    "Entity not found: " + entityName
                            ));

        } catch (IOException e) {

            throw new ProjectException(
                    "Unable to search entity.",
                    e
            );

        }

    }

}