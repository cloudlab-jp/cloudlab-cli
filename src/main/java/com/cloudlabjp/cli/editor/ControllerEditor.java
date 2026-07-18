package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.cloudlabjp.cli.generator.factory.field.FinalFieldFactory;

public class ControllerEditor {

    private final ClassEditor editor;

    public ControllerEditor(ClassEditor editor) {
        this.editor = editor;
    }

    public void configure(String path) {

        editor.annotations()

                .add(JavaAnnotation.restController())

                .add(JavaAnnotation.requestMapping(path))

                .add(JavaAnnotation.requiredArgsConstructor());

    }

    public void addDependency(String type,
                              String name) {

        if (editor.fields().hasField(name)) {
            return;
        }

        editor.fields()

                .add(
                        FinalFieldFactory.build(
                                type,
                                name
                        )
                );

    }

}