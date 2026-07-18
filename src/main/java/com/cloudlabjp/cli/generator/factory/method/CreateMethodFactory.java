package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.body.create.CreateBodyGenerator;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class CreateMethodFactory {

    private static final CreateBodyGenerator bodyGenerator =
            new CreateBodyGenerator();

    private CreateMethodFactory() {
    }

    public static MethodDefinition build(String entityName) {

        return new MethodDefinitionBuilder()

                .name("create")

                .returnType(entityName + "Response")

                .parameter(
                        "Create" + entityName + "Request",
                        "request"
                )

                .body(
                        bodyGenerator.generate(entityName)
                )

                .build();

    }

}