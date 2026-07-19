package com.cloudlabjp.cli.parser;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.ArrayList;
import java.util.List;

public class FieldParser {

    public List<FieldDefinition> parse(List<String> values) {
        System.out.println(">>> FieldParser ejecutándose");
        List<FieldDefinition> fields = new ArrayList<>();

        if (values == null || values.isEmpty()) {
            return fields;
        }

        for (String value : values) {

            String[] parts = value.split(":");

            if (parts.length != 2) {
                throw new IllegalArgumentException(
                        "Invalid field definition: " + value
                );
            }

            String name = parts[0].trim();

            String type = parts[1].trim();

            boolean required = false;

            if (type.endsWith("!")) {

                required = true;

                type = type.substring(0, type.length() - 1);

            }

            fields.add(

                    new FieldDefinition(

                            name,

                            type,

                            required

                    )

            );

        }
        System.out.println(fields);
        return fields;

    }

}