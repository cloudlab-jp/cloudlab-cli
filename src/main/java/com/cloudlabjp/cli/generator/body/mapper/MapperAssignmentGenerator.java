package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class MapperAssignmentGenerator {

    private final AssignmentGeneratorRegistry resolver =
            new AssignmentGeneratorRegistry();


    public String entityFromRequest(
            String entityName,
            List<FieldDefinition> fields
    ) {

        StringBuilder builder = new StringBuilder();

        builder.append("var entity = new ")
                .append(entityName)
                .append("();\n\n");

        for (FieldDefinition field : fields) {

            builder.append(
                    resolver.entityAssignment(field)
            );

        }

        builder.append("\nreturn entity;");

        return builder.toString();

    }

    public String updateEntity(
            String entityName,
            List<FieldDefinition> fields
    ) {

        StringBuilder builder = new StringBuilder();

        for (FieldDefinition field : fields) {

            builder.append(
                    resolver.updateAssignment(field)
            );

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

            builder.append(
                    resolver.responseAssignment(field)
            );

        }

        builder.append("\nreturn response;");

        return builder.toString();

    }

}