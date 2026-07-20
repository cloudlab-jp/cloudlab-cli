package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class MapperAssignmentGenerator {

    public String entityFromRequest(
            String entityName,
            List<FieldDefinition> fields
    ) {

        StringBuilder builder = new StringBuilder();

        builder.append("var entity = new ")
                .append(entityName)
                .append("();\n\n");

        for (FieldDefinition field : fields) {

            builder.append("entity.set")
                    .append(capitalize(field.name()))
                    .append("(request.get")
                    .append(capitalize(field.name()))
                    .append("());\n");

        }

        builder.append("\nreturn entity;");

        return builder.toString();

    }

    public String updateEntity(List<FieldDefinition> fields) {

        StringBuilder builder = new StringBuilder();

        for (FieldDefinition field : fields) {

            builder.append("entity.set")
                    .append(capitalize(field.name()))
                    .append("(request.get")
                    .append(capitalize(field.name()))
                    .append("());\n");

        }

        return builder.toString();

    }

    public String responseFromEntity(
            String entityName,
            List<FieldDefinition> fields
    ) {

        StringBuilder builder = new StringBuilder();

        builder.append("var response = new ")
                .append(entityName)
                .append("Response();\n\n");

        for (FieldDefinition field : fields) {

            builder.append("response.set")
                    .append(capitalize(field.name()))
                    .append("(entity.get")
                    .append(capitalize(field.name()))
                    .append("());\n");

        }

        builder.append("\nreturn response;");

        return builder.toString();

    }

    private String capitalize(String value) {

        return Character.toUpperCase(value.charAt(0))

                + value.substring(1);

    }

}