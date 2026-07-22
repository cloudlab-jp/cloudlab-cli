package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.EditableField;
import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.generator.factory.field.FieldFactory;
import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class FieldConfigurer {

    private final EnumConfigurer enumConfigurer =
            new EnumConfigurer();

    public void configure(
            CompilationUnitEditor unit,
            String ownerEntity,
            List<FieldDefinition> fields
    ) {

        for (FieldDefinition field : fields) {

            EditableField editableField =

                    unit.clazz()

                            .fields()

                            .add(

                                    FieldFactory.build(
                                            ownerEntity,
                                            field
                                    )

                            );

            enumConfigurer.configure(
                    editableField,
                    field
            );

        }

    }

}