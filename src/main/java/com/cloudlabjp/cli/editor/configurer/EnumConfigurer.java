package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.EditableField;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

public class EnumConfigurer {

    public void configure(
            EditableField field,
            FieldDefinition definition
    ) {

        if (definition.kind() != FieldKind.ENUM) {
            return;
        }

        field.annotate(
                "@Enumerated(EnumType.STRING)"
        );

    }

}