package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class FindByIdServiceMethodFactory {

    private FindByIdServiceMethodFactory() {
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
                        """
                        return repository.findById(id)
                                .map(mapper::toResponse)
                                .orElseThrow();
                        """
                )

                .build();

    }

}