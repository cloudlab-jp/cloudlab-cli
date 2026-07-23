package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;

public class RepositoryNameResolver {

    public String resolve(FieldDefinition field) {

        return decapitalize(field.type()) + "Repository";

    }

    private String decapitalize(String value) {

        return Character.toLowerCase(value.charAt(0))
                + value.substring(1);

    }

}