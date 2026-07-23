package com.cloudlabjp.cli.generator.builder;

import com.cloudlabjp.cli.generator.resolver.DtoFieldNameResolver;
import com.cloudlabjp.cli.generator.resolver.DtoTypeResolver;
import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class EntitySourceBuilder {

    private final DtoTypeResolver dtoTypeResolver =
            new DtoTypeResolver();

    private final DtoFieldNameResolver dtoFieldNameResolver =
            new DtoFieldNameResolver();

    public String buildFields(
            List<FieldDefinition> fields,
            FieldTarget target
    ) {

        if (fields == null || fields.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (FieldDefinition field : fields) {

            if (target != FieldTarget.RESPONSE && field.required()) {

                if ("String".equals(field.type())) {

                    builder.append("    @NotBlank")
                            .append(System.lineSeparator());

                } else {

                    builder.append("    @NotNull")
                            .append(System.lineSeparator());

                }

            }

            String fieldType =
                    target == FieldTarget.ENTITY
                            ? field.type()
                            : dtoTypeResolver.resolve(field);

            String fieldName =
                    target == FieldTarget.ENTITY
                            ? field.name()
                            : dtoFieldNameResolver.resolve(field);

            builder.append("    private ")
                    .append(fieldType)
                    .append(" ")
                    .append(fieldName)
                    .append(";")
                    .append(System.lineSeparator())
                    .append(System.lineSeparator());

        }

        return builder.toString();

    }

    public String buildConstructor(
            String className,
            List<FieldDefinition> fields
    ) {

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

    public String buildGetters(
            List<FieldDefinition> fields
    ) {

        return "";

    }

    public String buildSetters(
            List<FieldDefinition> fields
    ) {

        return "";

    }

}