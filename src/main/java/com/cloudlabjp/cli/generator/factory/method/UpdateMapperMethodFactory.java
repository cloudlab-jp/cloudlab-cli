package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.mapper.UpdateMapperBodyGenerator;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class UpdateMapperMethodFactory {

    private static final UpdateMapperBodyGenerator bodyGenerator =
            new UpdateMapperBodyGenerator();

    private UpdateMapperMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("update")

                .returnType("void")

                .parameter(
                        entityName,
                        "entity"
                )

                .parameter(
                        "Update" + entityName + "Request",
                        "request"
                )

                .body(
                        bodyGenerator.generate()
                )

                .build();

    }

}