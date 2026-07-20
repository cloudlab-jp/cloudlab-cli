package com.cloudlabjp.cli.parser;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.model.RelationshipDefinition;

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

                type = type.substring(
                        0,
                        type.length() - 1
                );

            }

            FieldKind kind = FieldKind.SIMPLE;

            RelationshipDefinition relationship = null;

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

            } else if (type.endsWith("@")) {

                kind = FieldKind.ENUM;

                type = type.substring(
                        0,
                        type.length() - 1
                );

            }

            fields.add(

                    new FieldDefinition(

                            name,

                            type,

                            kind,

                            required,

                            relationship

                    )

            );

        }

        System.out.println(fields);

        return fields;

    }

}