package com.cloudlabjp.cli.editor.relationship;

import com.cloudlabjp.cli.editor.ClassEditor;
import com.cloudlabjp.cli.generator.factory.field.OneToOneInverseFieldFactory;

public class OneToOneEditor {

    private final ClassEditor clazz;

    public OneToOneEditor(ClassEditor clazz) {
        this.clazz = clazz;
    }

    public void add(
            String entityName,
            String mappedBy
    ) {

        String fieldName =
                Character.toLowerCase(entityName.charAt(0))
                        + entityName.substring(1);

        if (clazz.hasField(fieldName)) {
            return;
        }

        clazz.fields()

                .add(
                        OneToOneInverseFieldFactory.build(
                                entityName,
                                mappedBy
                        )
                );

    }

}