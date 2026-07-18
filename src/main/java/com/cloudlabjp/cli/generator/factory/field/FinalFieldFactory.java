package com.cloudlabjp.cli.generator.factory.field;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.FieldDeclaration;

public final class FinalFieldFactory {

    private FinalFieldFactory() {
    }

    public static FieldDeclaration build(String type, String name) {

        return StaticJavaParser.parseBodyDeclaration(
                "private final " + type + " " + name + ";"
        ).asFieldDeclaration();

    }

}