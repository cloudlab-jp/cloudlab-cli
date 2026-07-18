package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.factory.ServiceBodyFactory;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class FindByIdMethodFactory {

    private FindByIdMethodFactory() {
    }

    public static MethodDefinition build(String entityName) {

        return new MethodDefinitionBuilder()

                .name("findById")

                .returnType(entityName + "Response")

                .parameter("Long", "id")

                .body(
                        ServiceBodyFactory.findByIdBody()
                )

                .build();

    }

}