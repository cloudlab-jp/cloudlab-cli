package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.generator.resolver.DtoFieldNameResolver;
import com.cloudlabjp.cli.model.FieldDefinition;

public class RelationExpressionGenerator {

    private final RepositoryNameResolver repositoryResolver =
            new RepositoryNameResolver();

    private final DtoFieldNameResolver dtoResolver =
            new DtoFieldNameResolver();

    public String entityExpression(FieldDefinition field) {

        String dtoField =
                capitalize(dtoResolver.resolve(field));

        return repositoryResolver.resolve(field)
                + ".getReferenceById(request.get"
                + dtoField
                + "())";

    }

    public String collectionEntityExpression(FieldDefinition field) {

        String dtoField =
                capitalize(dtoResolver.resolve(field));

        return """
                request.get%s()
                        .stream()
                        .map(%s::getReferenceById)
                        .toList()
                """
                .formatted(
                        dtoField,
                        repositoryResolver.resolve(field)
                );

    }

    public String responseExpression(FieldDefinition field) {

        return """
                entity.get%s() != null
                        ? entity.get%s().getId()
                        : null
                """
                .formatted(
                        capitalize(field.name()),
                        capitalize(field.name())
                );

    }

    public String collectionResponseExpression(FieldDefinition field) {

        return """
                entity.get%s() == null
                        ? List.of()
                        : entity.get%s()
                                .stream()
                                .map(%s::getId)
                                .toList()
                """
                .formatted(
                        capitalize(field.name()),
                        capitalize(field.name()),
                        field.type()
                );

    }

    private String capitalize(String value) {

        return Character.toUpperCase(value.charAt(0))
                + value.substring(1);

    }

}