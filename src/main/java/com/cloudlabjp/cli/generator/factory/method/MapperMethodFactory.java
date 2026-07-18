package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class MapperMethodFactory {

    private MapperMethodFactory() {
    }

    public static MethodDefinition toEntity(String entity) {

        return new MethodDefinitionBuilder()

                .name("toEntity")

                .returnType(entity)

                .parameter(
                        "Create" + entity + "Request",
                        "request"
                )

                .body("""
                        return null;
                        """)

                .build();

    }

    public static MethodDefinition toResponse(String entity) {

        return new MethodDefinitionBuilder()

                .name("toResponse")

                .returnType(entity + "Response")

                .parameter(
                        entity,
                        "entity"
                )

                .body("""
                        return null;
                        """)

                .build();

    }

}