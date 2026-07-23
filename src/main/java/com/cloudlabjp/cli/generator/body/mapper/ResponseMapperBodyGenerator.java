package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class ResponseMapperBodyGenerator {

    private final MapperAssignmentGenerator generator =
            new MapperAssignmentGenerator();

    public String generate(
            String entityName,
            List<FieldDefinition> fields
    ) {

        return generator.responseFromEntity(
                entityName,
                fields
        );

    }

}