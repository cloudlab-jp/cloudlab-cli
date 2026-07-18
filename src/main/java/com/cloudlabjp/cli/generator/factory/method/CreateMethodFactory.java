package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.factory.ServiceBodyFactory;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class CreateMethodFactory {

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
                        ServiceBodyFactory.createBody(entityName)
                )

                .build();

    }

}