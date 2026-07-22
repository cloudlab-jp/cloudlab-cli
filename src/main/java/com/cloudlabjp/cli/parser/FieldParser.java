package com.cloudlabjp.cli.parser;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.model.RelationshipDefinition;

import java.util.ArrayList;
import java.util.List;

public class FieldParser {

    public List<FieldDefinition> parse(String values) {

        System.out.println(">>> FieldParser ejecutándose");

        List<FieldDefinition> fields = new ArrayList<>();

        if (values == null || values.isBlank()) {
            return fields;
        }

        for (String value : splitFields(values)) {

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

            FieldKind kind = FieldKind.SIMPLE;

            RelationshipDefinition relationship = null;

            List<String> enumValues = List.of();

            if (type.endsWith("#")) {

                kind = FieldKind.MANY_TO_ONE;

                type = type.substring(
                        0,
                        type.length() - 1
                );

                relationship = new RelationshipDefinition(
                        null,
                        name + "_id"
                );

            } else if (type.endsWith("&")) {

                kind = FieldKind.ONE_TO_ONE;

                type = type.substring(
                        0,
                        type.length() - 1
                );

                relationship = new RelationshipDefinition(
                        null,
                        name + "_id"
                );
            } else if (type.endsWith("[]")) {

                    kind = FieldKind.ONE_TO_MANY;

                    type = type.substring(
                            0,
                            type.length() - 2
                    );

                    relationship = new RelationshipDefinition(
                            null,
                            null
                    );

                } else if (type.endsWith("<>")) {

                    kind = FieldKind.MANY_TO_MANY;

                    type = type.substring(
                            0,
                            type.length() - 2
                    );

                    relationship = new RelationshipDefinition(
                            null,
                            null
                    );

                }  else if (type.endsWith("@")) {

                kind = FieldKind.ENUM;

                type = type.substring(
                        0,
                        type.length() - 1
                );

                int start = type.indexOf('(');

                if (start > 0 && type.endsWith(")")) {

                    String enumName =
                            type.substring(0, start);

                    String valuesText =
                            type.substring(
                                    start + 1,
                                    type.length() - 1
                            );

                    enumValues = List.of(
                                    valuesText.split(",")
                            )
                            .stream()
                            .map(String::trim)
                            .filter(v -> !v.isBlank())
                            .toList();

                    type = enumName;

                }

            }

            fields.add(

                    new FieldDefinition(

                            name,

                            type,

                            kind,

                            required,

                            relationship,

                            enumValues

                    )

            );

        }

        System.out.println(fields);

        return fields;

    }

    private List<String> splitFields(String input) {

        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        int parentheses = 0;

        for (char c : input.toCharArray()) {

            switch (c) {

                case '(' -> parentheses++;

                case ')' -> parentheses--;

                case ',' -> {

                    if (parentheses == 0) {

                        result.add(current.toString().trim());

                        current.setLength(0);

                        continue;

                    }

                }

            }

            current.append(c);

        }

        if (!current.isEmpty()) {

            result.add(current.toString().trim());

        }

        return result;

    }

}