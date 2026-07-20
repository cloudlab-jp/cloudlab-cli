package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class FindAllServiceMethodFactory {

    private FindAllServiceMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("findAll")

                .returnType("List<" + entityName + "Response>")

                .body(
                        """
                        return repository.findAll()
                                .stream()
                                .map(mapper::toResponse)
                                .toList();
                        """
                )

                .build();

    }

}