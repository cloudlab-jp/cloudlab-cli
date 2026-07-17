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

}