package com.cloudlabjp.cli.editor.configurer.imports;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.List;

public class RepositoryImportsConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            List<FieldDefinition> fields
    ) {
        boolean required = fields.stream()

                .anyMatch(field ->
                        field.kind() == FieldKind.MANY_TO_ONE);

        if (required) {

            unit.imports()

                    .add("java.util.List");

        }
    }

}