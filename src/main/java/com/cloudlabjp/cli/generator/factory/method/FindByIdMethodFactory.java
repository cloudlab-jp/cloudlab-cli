package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.find.FindByIdBodyGenerator;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class FindByIdMethodFactory {

    private static final FindByIdBodyGenerator bodyGenerator =
            new FindByIdBodyGenerator();

    private FindByIdMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("findById")

                .returnType(entityName + "Response")

                .parameter(
                        "Long",
                        "id"
                )

                .body(
                        bodyGenerator.generate(entityName)
                )

                .build();

    }

}