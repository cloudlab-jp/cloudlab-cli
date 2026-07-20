package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class DeleteServiceMethodFactory {

    private DeleteServiceMethodFactory() {
    }

    public static MethodDeclaration build() {

        return new MethodAstBuilder()

                .publicMethod()

                .name("delete")

                .returnType("void")

                .parameter(
                        "Long",
                        "id"
                )

                .body(
                        """
                        repository.deleteById(id);
                        """
                )

                .build();

    }

}