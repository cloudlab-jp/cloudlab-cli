package com.cloudlabjp.cli.generator.resolver;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

public class DtoTypeResolver {

    public String resolve(FieldDefinition field) {

        return switch (field.kind()) {

            case SIMPLE,
                 ENUM -> field.type();

            case MANY_TO_ONE,
                 ONE_TO_ONE -> "Long";

            case ONE_TO_MANY,
                 MANY_TO_MANY -> "java.util.List<Long>";

        };

    }

}