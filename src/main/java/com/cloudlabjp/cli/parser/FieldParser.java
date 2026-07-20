package com.cloudlabjp.cli.parser;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.ArrayList;
import java.util.List;

public class FieldParser {

    private final RelationshipParser relationshipParser =
            new RelationshipParser();

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

                type = type.substring(
                        0,
                        type.length() - 1
                );

            }

            ParsedRelationship parsed =
                    relationshipParser.parse(
                            name,
                            type
                    );

            fields.add(

                    new FieldDefinition(

                            name,

                            parsed.type(),

                            parsed.kind(),

                            required,

                            parsed.relationship()

                    )

            );

        }

        System.out.println(fields);

        return fields;

    }

}