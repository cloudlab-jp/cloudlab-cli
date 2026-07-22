package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class ManyToManyFieldFactory {

    private ManyToManyFieldFactory() {
    }

    public static FieldDeclaration build(
            String ownerEntity,
            FieldDefinition field
    ) {

        String owner =
                Character.toLowerCase(ownerEntity.charAt(0))
                        + ownerEntity.substring(1);

        String inverse =
                Character.toLowerCase(field.type().charAt(0))
                        + field.type().substring(1);

        return new FieldAstBuilder()

                .privateField()

                .annotation(
                        JavaAnnotation.manyToManyOwner()
                )

                .annotation(
                        JavaAnnotation.joinTable(
                                owner,
                                inverse
                        )
                )

                .type(
                        "List<" + field.type() + ">"
                )

                .name(field.name())

                .initializer("new ArrayList<>()")

                .build();

    }

}