package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.List;

public class ResponseMapperBodyGenerator {

    public String generate(
            String entityName,
            List<FieldDefinition> fields
    ) {

        StringBuilder body = new StringBuilder();

        body.append(entityName)
                .append("Response response = new ")
                .append(entityName)
                .append("Response();\n\n");

        for (FieldDefinition field : fields) {

            String property = capitalize(field.name());

            if (field.kind() == FieldKind.MANY_TO_ONE
                    || field.kind() == FieldKind.ONE_TO_ONE) {

                body.append("response.set")
                        .append(property)
                        .append("(entity.get")
                        .append(property)
                        .append("() != null ? entity.get")
                        .append(property)
                        .append("().getId() : null);\n");

            } else {

                body.append("response.set")
                        .append(property)
                        .append("(entity.get")
                        .append(property)
                        .append("());\n");

            }

        }

        body.append("\nreturn response;");

        return body.toString();

    }

    private String capitalize(String value) {

        return Character.toUpperCase(value.charAt(0))
                + value.substring(1);

    }

}