package com.cloudlabjp.cli.generator.relationship;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

public class RelationshipGenerator {

    private final ManyToOneGenerator manyToOne =
            new ManyToOneGenerator();

    public void generate(
            CompilationUnitEditor unit,
            FieldDefinition field
    ) {

        if (field.kind() == FieldKind.SIMPLE) {
            return;
        }

        switch (field.kind()) {

            case MANY_TO_ONE ->
                    manyToOne.generate(
                            unit,
                            field
                    );

            default -> {
            }

        }

    }

}