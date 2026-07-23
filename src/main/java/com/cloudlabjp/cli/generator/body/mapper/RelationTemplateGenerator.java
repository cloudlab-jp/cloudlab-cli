package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.generator.resolver.DtoFieldNameResolver;
import com.cloudlabjp.cli.model.FieldDefinition;

public class RelationTemplateGenerator {

    private final DtoFieldNameResolver dtoResolver =
            new DtoFieldNameResolver();

    public String singleRelation(
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

    public String collectionRelation(
            FieldDefinition field,
            String expression
    ) {

        String dtoField =
                capitalize(dtoResolver.resolve(field));

        return """
                if (request.get%s() != null) {
                    entity.set%s(
                            %s
                    );
                }
                """
                .formatted(
                        dtoField,
                        capitalize(field.name()),
                        expression
                );

    }

    public String singleResponse(
            FieldDefinition field,
            String expression
    ) {

        String dtoField =
                capitalize(dtoResolver.resolve(field));

        return """
                response.set%s(
                        %s
                );
                """
                .formatted(
                        dtoField,
                        expression
                );

    }

    public String collectionResponse(
            FieldDefinition field,
            String expression
    ) {

        String dtoField =
                capitalize(dtoResolver.resolve(field));

        return """
                response.set%s(
                        %s
                );
                """
                .formatted(
                        dtoField,
                        expression
                );

    }

    private String capitalize(String value) {

        return Character.toUpperCase(value.charAt(0))
                + value.substring(1);

    }

}