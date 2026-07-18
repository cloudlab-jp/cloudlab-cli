package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.create.CreateBodyGenerator;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class CreateMethodFactory {

    private static final CreateBodyGenerator bodyGenerator =
            new CreateBodyGenerator();

    private CreateMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("create")

                .returnType(entityName + "Response")

                .parameter(
                        "Create" + entityName + "Request",
                        "request"
                )

                .body(
                        bodyGenerator.generate(entityName)
                )

                .build();

    }

}