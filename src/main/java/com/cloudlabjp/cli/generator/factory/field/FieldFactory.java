package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class FieldFactory {

    private FieldFactory() {
    }

    public static FieldDeclaration build(
            FieldDefinition field
    ) {

        return switch (field.kind()) {

            case SIMPLE ->

                    SimpleFieldFactory.build(field);

            case MANY_TO_ONE ->

                    ManyToOneFieldFactory.build(field);

            case ONE_TO_MANY ->

                    OneToManyFieldFactory.build(field);

            case MANY_TO_MANY ->

                    ManyToManyFieldFactory.build(field);



        };

    }

}