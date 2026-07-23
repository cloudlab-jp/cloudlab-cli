package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.generator.resolver.DtoFieldNameResolver;
import com.cloudlabjp.cli.model.FieldDefinition;

public class SimpleExpressionGenerator {

    private final DtoFieldNameResolver dtoResolver =
            new DtoFieldNameResolver();

    public String entityExpression(
            FieldDefinition field
    ) {

        return "request.get"
                + capitalize(dtoResolver.resolve(field))
                + "()";

    }

    public String updateExpression(
            FieldDefinition field
    ) {

        return entityExpression(field);

    }

    public String responseExpression(
            FieldDefinition field
    ) {

        return "entity.get"
                + capitalize(field.name())
                + "()";

    }

    private String capitalize(String value) {

        return Character.toUpperCase(value.charAt(0))
                + value.substring(1);

    }

}