package com.cloudlabjp.cli.generator.relationship;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.model.FieldDefinition;

public class ManyToOneGenerator {

    public void generate(
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