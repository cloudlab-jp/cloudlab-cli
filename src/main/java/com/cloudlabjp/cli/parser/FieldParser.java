package com.cloudlabjp.cli.parser;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.ArrayList;
import java.util.List;

public class FieldParser {

    public List<FieldDefinition> parse(List<String> values) {

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

            fields.add(
                    new FieldDefinition(
                            parts[0].trim(),
                            parts[1].trim()
                    )
            );

        }

        return fields;

    }

}