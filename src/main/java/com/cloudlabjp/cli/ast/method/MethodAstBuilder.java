package com.cloudlabjp.cli.ast.method;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;

public class MethodAstBuilder {

    private final MethodDeclaration method =
            new MethodDeclaration();

    public MethodAstBuilder publicMethod() {

        method.setPublic(true);

        return this;

    }

    public MethodAstBuilder name(String name) {

        method.setName(name);

        return this;

    }

    public MethodAstBuilder returnType(String type) {

        method.setType(type);

        return this;

    }

    public MethodAstBuilder parameter(String type,
                                      String name) {

        method.addParameter(type, name);

        return this;

    }

    public MethodAstBuilder body(String body) {

        BlockStmt block =
                StaticJavaParser.parseBlock(
                        "{\n" + body + "\n}"
                );

        method.setBody(block);

        return this;

    }

    public MethodDeclaration build() {

        return method;

    }

}