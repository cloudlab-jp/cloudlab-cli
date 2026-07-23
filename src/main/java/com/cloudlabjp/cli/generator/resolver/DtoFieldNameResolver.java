package com.cloudlabjp.cli.generator.resolver;

import com.cloudlabjp.cli.model.FieldDefinition;

public class DtoFieldNameResolver {

    public String resolve(FieldDefinition field) {

        return switch (field.kind()) {

            case MANY_TO_ONE,
                 ONE_TO_ONE -> field.name() + "Id";

            case ONE_TO_MANY,
                 MANY_TO_MANY -> singular(field.name()) + "Ids";

            default -> field.name();

        };

    }

    private String singular(String value) {

        if (value.endsWith("s") && value.length() > 1) {
            return value.substring(0, value.length() - 1);
        }

        return value;

    }

}