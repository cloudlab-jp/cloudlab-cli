package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.generator.configurer.FieldValidationConfigurer;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class SimpleFieldFactory {

    private static final FieldValidationConfigurer validation =
            new FieldValidationConfigurer();

    private SimpleFieldFactory() {
    }

    public static FieldDeclaration build(
            FieldDefinition field
    ) {

        FieldDeclaration declaration =

                new FieldAstBuilder()

                        .privateField()

                        .type(field.type())

                        .name(field.name())

                        .build();

        validation.configure(
                declaration,
                field
        );

        return declaration;

    }

}