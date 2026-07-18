package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.delete.DeleteBodyGenerator;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class DeleteMethodFactory {

    private static final DeleteBodyGenerator bodyGenerator =
            new DeleteBodyGenerator();

    private DeleteMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("delete")

                .returnType("void")

                .parameter(
                        "Long",
                        "id"
                )

                .body(
                        bodyGenerator.generate()
                )

                .build();

    }

}