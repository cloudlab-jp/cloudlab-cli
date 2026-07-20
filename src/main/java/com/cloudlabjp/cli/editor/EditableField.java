package com.cloudlabjp.cli.editor;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;

public class EditableField {

    private final FieldDeclaration field;

    public EditableField(FieldDeclaration field) {
        this.field = field;
    }

    private void addIfMissing(AnnotationExpr annotation) {

        String name = annotation.getNameAsString();

        boolean exists = field.getAnnotations()
                .stream()
                .anyMatch(a -> a.getNameAsString().equals(name));

        if (!exists) {
            field.addAnnotation(annotation);
        }
    }

    public EditableField annotate(String annotation) {

        addIfMissing(
                StaticJavaParser.parseAnnotation(annotation)
        );

        return this;
    }

}