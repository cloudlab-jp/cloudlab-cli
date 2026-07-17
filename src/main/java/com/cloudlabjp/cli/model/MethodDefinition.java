package com.cloudlabjp.cli.model;

import java.util.List;

public record MethodDefinition(

        String name,

        String returnType,

        List<ParameterDefinition> parameters,

        String body

) {
}