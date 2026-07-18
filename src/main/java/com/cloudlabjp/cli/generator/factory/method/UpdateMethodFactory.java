package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.body.update.UpdateBodyGenerator;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class UpdateMethodFactory {

    private static final UpdateBodyGenerator bodyGenerator =
            new UpdateBodyGenerator();

    private UpdateMethodFactory() {
    }

    public static MethodDefinition build(String entityName) {

        return new MethodDefinitionBuilder()

                .name("update")

                .returnType(entityName + "Response")

                .parameter("Long", "id")

                .parameter(
                        "Update" + entityName + "Request",
                        "request"
                )

                .body(
                        bodyGenerator.generate()
                )

                .build();

    }

}