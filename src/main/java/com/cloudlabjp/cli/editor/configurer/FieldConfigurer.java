package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.generator.factory.field.FieldFactory;
import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class FieldConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            List<FieldDefinition> fields
    ) {

        for (FieldDefinition field : fields) {

            if (unit.clazz().hasField(field.name())) {
                continue;
            }

            unit.clazz()
                    .fields()
                    .add(FieldFactory.build(field));

        }

    }

}