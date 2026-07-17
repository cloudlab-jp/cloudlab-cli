package com.cloudlabjp.cli.template;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ImportResolver {

    public String resolve(List<FieldDefinition> fields) {

        Set<String> imports = new LinkedHashSet<>();

        for (FieldDefinition field : fields) {

            switch (field.type()) {

                case "BigDecimal" ->
                        imports.add("import java.math.BigDecimal;");

                case "LocalDate" ->
                        imports.add("import java.time.LocalDate;");

                case "LocalDateTime" ->
                        imports.add("import java.time.LocalDateTime;");

                case "UUID" ->
                        imports.add("import java.util.UUID;");
            }

        }

        return String.join(System.lineSeparator(), imports);

    }

}