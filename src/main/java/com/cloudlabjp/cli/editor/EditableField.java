package com.cloudlabjp.cli.editor;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;

public class EditableField {

    private final FieldDeclaration field;

    public EditableField(FieldDeclaration field) {
        this.field = field;
    }

    public EditableField annotate(AnnotationExpr annotation) {

        String annotationName = annotation.getNameAsString();

        boolean exists = field.getAnnotations()
                .stream()
                .anyMatch(a ->
                        a.getNameAsString().equals(annotationName));

        if (!exists) {
            field.addAnnotation(annotation);
        }

        return this;

    }

    public EditableField annotate(
            String annotation
    ) {

        return annotate(
                StaticJavaParser.parseAnnotation(annotation)
        );

    }

}