package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.cloudlabjp.cli.generator.factory.field.FinalFieldFactory;
import com.github.javaparser.ast.body.MethodDeclaration;

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

    public void addDependency(String type, String name) {

        if (editor.fields().hasField(name)) {
            return;
        }

        editor.fields()

                .add(
                        FinalFieldFactory.build(type, name)
                );

    }

    public void addMethod(MethodDeclaration method) {

        if (!editor.hasMethod(method.getNameAsString())) {

            editor.addMethod(method);

        }

    }

}