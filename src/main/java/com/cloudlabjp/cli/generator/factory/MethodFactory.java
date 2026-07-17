package com.cloudlabjp.cli.generator.factory;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class MethodFactory {

    private MethodFactory() {
    }

    public static MethodDefinition emptyMethod(String name) {

        return new MethodDefinitionBuilder()
                .name(name)
                .build();

    }

    public static MethodDefinition createMethod(String entityName) {

        return new MethodDefinitionBuilder()

                .name("create")

                .returnType(entityName + "Response")

                .parameter(
                        "Create" + entityName + "Request",
                        "request"
                )

                .body("""
                    return null;
                    """)

                .build();

    }

}