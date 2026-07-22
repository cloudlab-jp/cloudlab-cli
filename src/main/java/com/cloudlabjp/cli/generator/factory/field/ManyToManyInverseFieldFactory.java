package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class ManyToManyInverseFieldFactory {

    private ManyToManyInverseFieldFactory() {
    }

    public static FieldDeclaration build(
            String entityName,
            String mappedBy
    ) {

        String fieldName =
                Character.toLowerCase(entityName.charAt(0))
                        + entityName.substring(1)
                        + "s";

        return new FieldAstBuilder()

                .privateField()

                .annotation(
                        JavaAnnotation.manyToMany(mappedBy)
                )

                .type("List<" + entityName + ">")

                .name(fieldName)

                .initializer("new ArrayList<>()")

                .build();

    }

}