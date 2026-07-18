package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.builder.MethodDefinitionBuilder;
import com.cloudlabjp.cli.generator.body.find.FindAllBodyGenerator;
import com.cloudlabjp.cli.model.MethodDefinition;

public final class FindAllMethodFactory {

    private static final FindAllBodyGenerator bodyGenerator =
            new FindAllBodyGenerator();

    private FindAllMethodFactory() {
    }

    public static MethodDefinition build(String entityName) {

        return new MethodDefinitionBuilder()

                .name("findAll")

                .returnType("List<" + entityName + "Response>")

                .body(
                        bodyGenerator.generate()
                )

                .build();

    }

}