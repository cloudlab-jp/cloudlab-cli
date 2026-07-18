package com.cloudlabjp.cli.editor.converter;

import com.cloudlabjp.cli.model.MethodDefinition;
import com.cloudlabjp.cli.model.ParameterDefinition;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;

public final class MethodDefinitionConverter {

    private MethodDefinitionConverter() {
    }

    public static MethodDeclaration convert(
            MethodDefinition definition
    ) {

        MethodDeclaration method =
                new MethodDeclaration();

        method.setPublic(true);

        method.setName(
                definition.name()
        );

        method.setType(
                definition.returnType()
        );

        for (ParameterDefinition parameter : definition.parameters()) {

            method.addParameter(
                    parameter.type(),
                    parameter.name()
            );

        }

        BlockStmt body =
                StaticJavaParser.parseBlock(
                        "{\n" +
                                definition.body() +
                                "\n}"
                );

        method.setBody(body);

        return method;

    }

}