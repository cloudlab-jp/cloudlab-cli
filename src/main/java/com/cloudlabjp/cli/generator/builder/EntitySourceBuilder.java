package com.cloudlabjp.cli.generator.builder;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class EntitySourceBuilder {

    public String buildFields(List<FieldDefinition> fields) {

        if (fields == null || fields.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (FieldDefinition field : fields) {

            builder.append("    private ")
                    .append(field.type())
                    .append(" ")
                    .append(field.name())
                    .append(";")
                    .append(System.lineSeparator());

        }

        return builder.toString();

    }

    public String buildConstructor(String className,
                                   List<FieldDefinition> fields) {

        if (fields == null || fields.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        builder.append("    public ")
                .append(className)
                .append("(");

        for (int i = 0; i < fields.size(); i++) {

            FieldDefinition field = fields.get(i);

            builder.append(field.type())
                    .append(" ")
                    .append(field.name());

            if (i < fields.size() - 1) {
                builder.append(", ");
            }

        }

        builder.append(") {")
                .append(System.lineSeparator());

        for (FieldDefinition field : fields) {

            builder.append("        this.")
                    .append(field.name())
                    .append(" = ")
                    .append(field.name())
                    .append(";")
                    .append(System.lineSeparator());

        }

        builder.append("    }");

        return builder.toString();

    }

    public String buildGetters(List<FieldDefinition> fields) {

        return "";

    }

    public String buildSetters(List<FieldDefinition> fields) {

        return "";

    }

}