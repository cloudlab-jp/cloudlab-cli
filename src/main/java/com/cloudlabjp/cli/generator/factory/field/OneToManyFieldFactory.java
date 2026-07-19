package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class OneToManyFieldFactory {

    private OneToManyFieldFactory() {
    }

    public static FieldDeclaration build(
            String entityName,
            String mappedBy
    ) {

        return new FieldAstBuilder()

                .privateField()

                .annotation(
                        JavaAnnotation.oneToMany(mappedBy)
                )

                .type("List<" + entityName + ">")

                .name(
                        Character.toLowerCase(entityName.charAt(0))
                                + entityName.substring(1)
                                + "s"
                )

                .initializer("new ArrayList<>()")

                .build();

    }

    public static FieldDeclaration build(FieldDefinition field) {

        throw new UnsupportedOperationException(
                "OneToOne not implemented."
        );

    }

}