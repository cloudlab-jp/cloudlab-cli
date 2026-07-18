package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.factory.ServiceBodyFactory;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class DeleteMethodFactory {

    private DeleteMethodFactory() {
    }

    public static MethodDefinition build() {

        return new MethodDefinitionBuilder()

                .name("delete")

                .returnType("void")

                .parameter("Long", "id")

                .body(
                        ServiceBodyFactory.deleteBody()
                )

                .build();

    }

}