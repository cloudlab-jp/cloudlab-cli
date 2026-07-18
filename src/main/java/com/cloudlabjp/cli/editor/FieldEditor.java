package com.cloudlabjp.cli.editor;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;

public class FieldEditor {

    private final ClassOrInterfaceDeclaration clazz;

    public FieldEditor(ClassOrInterfaceDeclaration clazz) {
        this.clazz = clazz;
    }

    public EditableField add(String type,
                             String name) {

        FieldDeclaration field =
                clazz.addField(
                        type,
                        name
                );

        field.setPrivate(true);

        return new EditableField(field);

    }

}