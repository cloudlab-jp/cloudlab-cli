package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class OneToOneInverseFieldFactory {

    private OneToOneInverseFieldFactory() {
    }

    public static FieldDeclaration build(
            String entityName,
            String mappedBy
    ) {

        return new FieldAstBuilder()

                .privateField()

                .annotation(
                        JavaAnnotation.oneToOne(mappedBy)
                )

                .type(entityName)

                .name(
                        Character.toLowerCase(entityName.charAt(0))
                                + entityName.substring(1)
                )

                .build();

    }

}