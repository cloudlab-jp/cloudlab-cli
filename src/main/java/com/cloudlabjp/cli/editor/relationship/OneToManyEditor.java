package com.cloudlabjp.cli.editor.relationship;

import com.cloudlabjp.cli.editor.ClassEditor;
import com.cloudlabjp.cli.generator.factory.field.OneToManyFieldFactory;

public class OneToManyEditor {

    private final ClassEditor clazz;

    public OneToManyEditor(ClassEditor clazz) {
        this.clazz = clazz;
    }

    public void add(
            String entityName,
            String mappedBy
    ) {

        String fieldName =
                Character.toLowerCase(entityName.charAt(0))
                        + entityName.substring(1)
                        + "s";

        if (clazz.hasField(fieldName)) {
            return;
        }

        clazz.fields()

                .add(
                        OneToManyFieldFactory.build(
                                entityName,
                                mappedBy
                        )
                );

    }

}