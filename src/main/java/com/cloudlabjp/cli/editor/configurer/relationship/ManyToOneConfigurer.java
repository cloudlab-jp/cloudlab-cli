package com.cloudlabjp.cli.editor.configurer.relationship;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.model.FieldDefinition;

public class ManyToOneConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            FieldDefinition field
    ) {

        unit.clazz()

                .fields()

                .field(field.name())

                .annotate("@ManyToOne(fetch = FetchType.LAZY)")

                .annotate(
                        "@JoinColumn(name = \"" +
                                field.relationship().joinColumn() +
                                "\")"
                );

    }

}