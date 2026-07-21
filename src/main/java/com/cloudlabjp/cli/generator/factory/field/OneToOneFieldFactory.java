package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class OneToOneFieldFactory {

    private OneToOneFieldFactory() {
    }

    public static FieldDeclaration build(
            FieldDefinition field
    ) {

        return new FieldAstBuilder()

                .privateField()

                .annotation(
                        JavaAnnotation.oneToOneOwner()
                )

                .annotation(
                        JavaAnnotation.joinColumn(
                                field.relationship().joinColumn()
                        )
                )

                .type(field.type())

                .name(field.name())

                .build();

    }

}