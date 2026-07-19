package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class ValidationImportsConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            List<FieldDefinition> fields
    ) {

        boolean hasNotBlank = false;

        boolean hasNotNull = false;

        for (FieldDefinition field : fields) {

            if (!field.required()) {
                continue;
            }

            if ("String".equals(field.type())) {

                hasNotBlank = true;

            } else {

                hasNotNull = true;

            }

        }

        if (hasNotBlank) {

            unit.imports()

                    .add("jakarta.validation.constraints.NotBlank");

        }

        if (hasNotNull) {

            unit.imports()

                    .add("jakarta.validation.constraints.NotNull");

        }

    }

}