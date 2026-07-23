package com.cloudlabjp.cli.generator.builder;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.List;

public class MapperFieldBuilder {

    public String build(List<FieldDefinition> fields) {

        StringBuilder builder = new StringBuilder();

        for (FieldDefinition field : fields) {

            if (field.kind() == FieldKind.MANY_TO_ONE
                    || field.kind() == FieldKind.ONE_TO_ONE
                    || field.kind() == FieldKind.MANY_TO_MANY) {

                builder.append("private final ")
                        .append(field.type())
                        .append("Repository ")
                        .append(decapitalize(field.type()))
                        .append("Repository;")
                        .append(System.lineSeparator())
                        .append(System.lineSeparator());

            }

        }

        return builder.toString();

    }

    private String decapitalize(String value) {

        return Character.toLowerCase(value.charAt(0))
                + value.substring(1);

    }

}