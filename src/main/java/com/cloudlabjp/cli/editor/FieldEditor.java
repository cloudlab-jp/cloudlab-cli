package com.cloudlabjp.cli.editor;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;

public class FieldEditor {

    private final ClassOrInterfaceDeclaration clazz;

    public FieldEditor(ClassOrInterfaceDeclaration clazz) {
        this.clazz = clazz;
    }

    public EditableField add(FieldDeclaration field) {

        String fieldName = field.getVariable(0).getNameAsString();

        boolean exists = clazz.getFields()

                .stream()

                .flatMap(f -> f.getVariables().stream())

                .anyMatch(variable ->
                        variable.getNameAsString().equals(fieldName));

        if (exists) {

            FieldDeclaration existing = clazz.getFields()

                    .stream()

                    .filter(f -> f.getVariable(0).getNameAsString().equals(fieldName))

                    .findFirst()

                    .orElseThrow();

            return new EditableField(existing);

        }

        clazz.addMember(field);

        return new EditableField(field);

    }

}