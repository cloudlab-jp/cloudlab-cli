package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

public class SimpleAssignmentGenerator
        implements AssignmentGenerator {

    private final SimpleExpressionGenerator expressions =
            new SimpleExpressionGenerator();

    private final SimpleTemplateGenerator templates =
            new SimpleTemplateGenerator();

    @Override
    public boolean supports(FieldKind kind) {

        return kind == FieldKind.SIMPLE
                || kind == FieldKind.ENUM;

    }

    @Override
    public String entity(
            FieldDefinition field
    ) {

        return templates.entity(
                field,
                expressions.entityExpression(field)
        );

    }

    @Override
    public String update(
            FieldDefinition field
    ) {

        return templates.update(
                field,
                expressions.updateExpression(field)
        );

    }

    @Override
    public String response(
            FieldDefinition field
    ) {

        return templates.response(
                field,
                expressions.responseExpression(field)
        );

    }

}