package com.cloudlabjp.cli.generator.factory.field;

import com.cloudlabjp.cli.ast.field.FieldAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class IdFieldFactory {

    private IdFieldFactory() {
    }

    public static FieldDeclaration build() {

        return new FieldAstBuilder()

                .privateField()

                .type("Long")

                .name("id")

                .annotation(JavaAnnotation.id())

                .annotation(JavaAnnotation.generatedValueIdentity())

                .build();

    }

}