package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class MapperMethodFactory {

    private MapperMethodFactory() {
    }

    public static MethodDeclaration toEntity(String entity) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("toEntity")

                .returnType(entity)

                .parameter(
                        "Create" + entity + "Request",
                        "request"
                )

                .body("""
                        return null;
                        """)

                .build();

    }

    public static MethodDeclaration toResponse(String entity) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("toResponse")

                .returnType(entity + "Response")

                .parameter(
                        entity,
                        "entity"
                )

                .body("""
                        return null;
                        """)

                .build();

    }

}