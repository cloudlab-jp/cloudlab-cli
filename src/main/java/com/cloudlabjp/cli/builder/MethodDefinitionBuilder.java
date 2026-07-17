package com.cloudlabjp.cli.builder;

import com.cloudlabjp.cli.model.MethodDefinition;
import com.cloudlabjp.cli.model.ParameterDefinition;

import java.util.ArrayList;
import java.util.List;

public class MethodDefinitionBuilder {

    private String name;

    private String returnType = "void";

    private final List<ParameterDefinition> parameters =
            new ArrayList<>();

    private String body = "";

    public MethodDefinitionBuilder name(String name) {

        this.name = name;

        return this;

    }

    public MethodDefinitionBuilder returnType(String returnType) {

        this.returnType = returnType;

        return this;

    }

    public MethodDefinitionBuilder parameter(String type,
                                             String name) {

        parameters.add(
                new ParameterDefinition(
                        type,
                        name
                )
        );

        return this;

    }

    public MethodDefinitionBuilder body(String body) {

        this.body = body;

        return this;

    }

    public MethodDefinition build() {

        return new MethodDefinition(

                name,

                returnType,

                parameters,

                body

        );

    }

}