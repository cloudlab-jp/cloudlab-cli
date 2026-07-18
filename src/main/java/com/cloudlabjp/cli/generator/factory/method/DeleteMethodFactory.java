package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.body.delete.DeleteBodyGenerator;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class DeleteMethodFactory {

    private static final DeleteBodyGenerator bodyGenerator =
            new DeleteBodyGenerator();

    private DeleteMethodFactory() {
    }

    public static MethodDefinition build() {

        return new MethodDefinitionBuilder()

                .name("delete")

                .returnType("void")

                .parameter("Long", "id")

                .body(
                        bodyGenerator.generate()
                )

                .build();

    }

}