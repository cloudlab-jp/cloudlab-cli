package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.body.find.FindByIdBodyGenerator;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class FindByIdMethodFactory {

    private static final FindByIdBodyGenerator bodyGenerator =
            new FindByIdBodyGenerator();

    private FindByIdMethodFactory() {
    }

    public static MethodDefinition build(String entityName) {

        return new MethodDefinitionBuilder()

                .name("findById")

                .returnType(entityName + "Response")

                .parameter("Long", "id")

                .body(
                        bodyGenerator.generate()
                )

                .build();

    }

}