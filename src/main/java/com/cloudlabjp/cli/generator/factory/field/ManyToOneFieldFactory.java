package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class ManyToOneFieldFactory {

    private ManyToOneFieldFactory() {
    }

    public static FieldDeclaration build(
            FieldDefinition field
    ) {

        return new FieldAstBuilder()

                .privateField()

                .annotation(
                        JavaAnnotation.manyToOneLazy()
                )

                .annotation(
                        JavaAnnotation.joinColumn(
                                field.name() + "_id"
                        )
                )

                .type(field.type())

                .name(field.name())

                .build();

    }

}