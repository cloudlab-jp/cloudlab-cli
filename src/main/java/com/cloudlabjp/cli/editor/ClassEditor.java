package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.model.MethodDefinition;
import com.cloudlabjp.cli.model.ParameterDefinition;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class ClassEditor {

    private final ClassOrInterfaceDeclaration clazz;

    public ClassEditor(ClassOrInterfaceDeclaration clazz) {
        this.clazz = clazz;
    }

    public void addMethod(MethodDefinition definition) {

        var method = clazz.addMethod(definition.name());

        method.setPublic(true);

        method.setType(definition.returnType());

        for (ParameterDefinition parameter : definition.parameters()) {

            method.addParameter(
                    parameter.type(),
                    parameter.name()
            );

        }

        method.setBody(
                StaticJavaParser.parseBlock(
                        "{\n" +
                                definition.body() +
                                "\n}"
                )
        );

    }

}