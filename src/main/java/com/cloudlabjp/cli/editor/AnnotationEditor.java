package com.cloudlabjp.cli.editor;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;

public class AnnotationEditor {

    private final ClassOrInterfaceDeclaration clazz;

    public AnnotationEditor(ClassOrInterfaceDeclaration clazz) {
        this.clazz = clazz;
    }

    public AnnotationEditor add(AnnotationExpr annotation) {

        boolean exists = clazz.getAnnotations()

                .stream()

                .anyMatch(a ->
                        a.getNameAsString()
                                .equals(annotation.getNameAsString()));

        if (!exists) {

            clazz.addAnnotation(annotation);

        }

        return this;

    }

}
