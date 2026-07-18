package com.cloudlabjp.cli.editor;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;

public class EditableField {

    private final FieldDeclaration field;

    public EditableField(FieldDeclaration field) {
        this.field = field;
    }

    public EditableField annotate(AnnotationExpr annotation) {

        field.addAnnotation(annotation);

        return this;

    }

}