package com.cloudlabjp.cli.ast.method;

import com.cloudlabjp.cli.ast.builder.AstBuilder;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;

public class MethodAstBuilder implements AstBuilder<MethodDeclaration> {

    private final MethodDeclaration method =
            new MethodDeclaration();

    private boolean abstractMethod = false;

    public MethodAstBuilder publicMethod() {

        method.setPublic(true);

        return this;

    }

    public MethodAstBuilder noModifier() {

        method.getModifiers().clear();

        return this;

    }

    public MethodAstBuilder inInterface() {

        method.getModifiers().clear();

        abstractMethod = true;

        return this;

    }

    public MethodAstBuilder abstractMethod() {

        abstractMethod = true;

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

    public MethodAstBuilder parameter(
            String type,
            String name
    ) {

        method.addParameter(type, name);

        return this;

    }

    public MethodAstBuilder parameter(
            String type,
            String name,
            AnnotationExpr... annotations
    ) {

        Parameter parameter = new Parameter();

        parameter.setType(type);

        parameter.setName(name);

        for (AnnotationExpr annotation : annotations) {

            parameter.addAnnotation(annotation);

        }

        method.addParameter(parameter);

        return this;

    }

    public MethodAstBuilder annotation(
            AnnotationExpr annotation
    ) {

        method.addAnnotation(annotation);

        return this;

    }

    public MethodAstBuilder body(String source) {

        BlockStmt block =
                StaticJavaParser.parseBlock(
                        "{\n" + source + "\n}"
                );

        method.setBody(block);

        return this;

    }

    @Override
    public MethodDeclaration build() {

        if (abstractMethod) {

            method.removeBody();

        }

        return method;

    }

}