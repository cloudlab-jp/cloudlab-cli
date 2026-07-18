package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;

public class ServiceEditor {

    private final ClassEditor editor;

    public ServiceEditor(ClassEditor editor) {
        this.editor = editor;
    }

    public void configure() {

        editor.annotations()

                .add(JavaAnnotation.service())

                .add(JavaAnnotation.requiredArgsConstructor());

    }

}