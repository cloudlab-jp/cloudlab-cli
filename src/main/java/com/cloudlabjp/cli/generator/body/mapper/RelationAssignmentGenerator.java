package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

public class RelationAssignmentGenerator
        implements AssignmentGenerator {

    private final RelationExpressionGenerator expressions =
            new RelationExpressionGenerator();

    private final RelationTemplateGenerator templates =
            new RelationTemplateGenerator();

    @Override
    public boolean supports(FieldKind kind) {

        return switch (kind) {

            case MANY_TO_ONE,
                 ONE_TO_ONE,
                 MANY_TO_MANY -> true;

            default -> false;

        };

    }

    @Override
    public String entity(
            FieldDefinition field
    ) {

        return switch (field.kind()) {

            case MANY_TO_ONE,
                 ONE_TO_ONE ->
                    singleRelation(field);

            case MANY_TO_MANY ->
                    collectionRelation(field);

            default ->
                    "";

        };

    }

    @Override
    public String update(
            FieldDefinition field
    ) {

        return entity(field);

    }

    @Override
    public String response(
            FieldDefinition field
    ) {

        return switch (field.kind()) {

            case MANY_TO_ONE,
                 ONE_TO_ONE ->
                    singleResponse(field);

            case MANY_TO_MANY ->
                    collectionResponse(field);

            default ->
                    "";

        };

    }

    private String singleRelation(
            FieldDefinition field
    ) {

        return templates.singleRelation(
                field,
                expressions.entityExpression(field)
        );

    }

    private String collectionRelation(
            FieldDefinition field
    ) {

        return templates.collectionRelation(
                field,
                expressions.collectionEntityExpression(field)
        );

    }

    private String singleResponse(
            FieldDefinition field
    ) {

        return templates.singleResponse(
                field,
                expressions.responseExpression(field)
        );

    }

    private String collectionResponse(
            FieldDefinition field
    ) {

        return templates.collectionResponse(
                field,
                expressions.collectionResponseExpression(field)
        );

    }

}