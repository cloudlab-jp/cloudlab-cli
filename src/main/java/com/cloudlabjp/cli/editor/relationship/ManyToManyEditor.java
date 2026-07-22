package com.cloudlabjp.cli.editor.relationship;

import com.cloudlabjp.cli.editor.ClassEditor;
import com.cloudlabjp.cli.generator.factory.field.ManyToManyInverseFieldFactory;

public class ManyToManyEditor {

    private final ClassEditor clazz;

    public ManyToManyEditor(ClassEditor clazz) {
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

        clazz.fields().add(

                ManyToManyInverseFieldFactory.build(
                        entityName,
                        mappedBy
                )

        );

    }

}