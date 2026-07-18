package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.find.FindAllBodyGenerator;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class FindAllMethodFactory {

    private static final FindAllBodyGenerator bodyGenerator =
            new FindAllBodyGenerator();

    private FindAllMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("findAll")

                .returnType(
                        "List<" + entityName + "Response>"
                )

                .body(
                        bodyGenerator.generate()
                )

                .build();

    }

}