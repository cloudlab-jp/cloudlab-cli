package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.cloudlabjp.cli.generator.factory.field.IdFieldFactory;

public class EntityEditor {

    private final ClassEditor editor;

    public EntityEditor(ClassEditor editor) {
        this.editor = editor;
    }

    public void configure(String tableName) {

        editor.annotations()

                .add(JavaAnnotation.entity())

                .add(JavaAnnotation.table(tableName))

                .add(JavaAnnotation.getter())

                .add(JavaAnnotation.setter())

                .add(JavaAnnotation.builder())

                .add(JavaAnnotation.noArgsConstructor())

                .add(JavaAnnotation.allArgsConstructor());

        editor.fields()

                .add(
                        IdFieldFactory.build()
                );

    }

}