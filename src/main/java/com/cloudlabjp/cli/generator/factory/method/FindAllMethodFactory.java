package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.factory.ServiceBodyFactory;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class FindAllMethodFactory {

    private FindAllMethodFactory() {
    }

    public static MethodDefinition build(String entityName) {

        return new MethodDefinitionBuilder()

                .name("findAll")

                .returnType("List<" + entityName + "Response>")

                .body(
                        ServiceBodyFactory.findAllBody()
                )

                .build();

    }

}