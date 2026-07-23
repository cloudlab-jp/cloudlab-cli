package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.generator.resolver.DtoFieldNameResolver;
import com.cloudlabjp.cli.model.FieldDefinition;

public class SimpleTemplateGenerator {

    private final DtoFieldNameResolver dtoResolver =
            new DtoFieldNameResolver();

    public String entity(
            FieldDefinition field,
            String expression
    ) {

        return """
                entity.set%s(
                        %s
                );
                """
                .formatted(
                        capitalize(field.name()),
                        expression
                );

    }

    public String update(
            FieldDefinition field,
            String expression
    ) {

        return entity(field, expression);

    }

    public String response(
            FieldDefinition field,
            String expression
    ) {

        return """
                response.set%s(
                        %s
                );
                """
                .formatted(
                        capitalize(dtoResolver.resolve(field)),
                        expression
                );

    }

    private String capitalize(String value) {

        return Character.toUpperCase(value.charAt(0))
                + value.substring(1);

    }

}