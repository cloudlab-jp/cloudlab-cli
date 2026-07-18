package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.update.UpdateBodyGenerator;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class UpdateMethodFactory {

    private static final UpdateBodyGenerator bodyGenerator =
            new UpdateBodyGenerator();

    private UpdateMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("update")

                .returnType(entityName + "Response")

                .parameter(
                        "Long",
                        "id"
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