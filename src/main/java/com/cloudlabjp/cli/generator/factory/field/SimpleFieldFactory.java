package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class SimpleFieldFactory {

    private SimpleFieldFactory() {
    }

    public static FieldDeclaration build(
            FieldDefinition field
    ) {

        return new FieldAstBuilder()

                .privateField()

                .type(field.type())

                .name(field.name())

                .build();

    }

}