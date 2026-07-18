package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.generator.factory.field.SimpleFieldFactory;
import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class FieldConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            List<FieldDefinition> fields
    ) {

        for (FieldDefinition field : fields) {

            unit.clazz()

                    .fields()

                    .add(
                            SimpleFieldFactory.build(field)
                    );

        }

    }

}