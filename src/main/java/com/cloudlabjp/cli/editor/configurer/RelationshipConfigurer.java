package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.configurer.relationship.ManyToOneConfigurer;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.List;

public class RelationshipConfigurer {

    private final ManyToOneConfigurer manyToOne =
            new ManyToOneConfigurer();

    public void configure(
            CompilationUnitEditor unit,
            List<FieldDefinition> fields
    ) {

        for (FieldDefinition field : fields) {

            switch (field.kind()) {

                case MANY_TO_ONE ->

                        manyToOne.configure(
                                unit,
                                field
                        );

                default -> {
                }

            }

        }

    }

}