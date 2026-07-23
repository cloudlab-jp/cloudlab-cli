package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JavaTypeImportResolver {

    public Set<String> resolve(List<FieldDefinition> fields) {

        Set<String> imports = new LinkedHashSet<>();

        if (fields == null) {
            return imports;
        }

        for (FieldDefinition field : fields) {

            // DTOs con colecciones
            if (field.kind() == FieldKind.MANY_TO_MANY) {
                imports.add("java.util.List");
            }

            switch (field.type()) {

                case "BigDecimal" ->
                        imports.add("java.math.BigDecimal");

                case "LocalDate" ->
                        imports.add("java.time.LocalDate");

                case "LocalDateTime" ->
                        imports.add("java.time.LocalDateTime");

                case "LocalTime" ->
                        imports.add("java.time.LocalTime");

                case "UUID" ->
                        imports.add("java.util.UUID");

                case "Instant" ->
                        imports.add("java.time.Instant");

                case "OffsetDateTime" ->
                        imports.add("java.time.OffsetDateTime");

                default -> {
                }

            }

        }

        return imports;

    }

}