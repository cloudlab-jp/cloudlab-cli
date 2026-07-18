package com.cloudlabjp.cli.editor.annotation;

import com.github.javaparser.ast.expr.*;

public final class JavaAnnotation {

    private JavaAnnotation() {
    }

    public static AnnotationExpr entity() {

        return new MarkerAnnotationExpr("Entity");

    }

    public static AnnotationExpr getter() {

        return new MarkerAnnotationExpr("Getter");

    }

    public static AnnotationExpr setter() {

        return new MarkerAnnotationExpr("Setter");

    }

    public static AnnotationExpr builder() {

        return new MarkerAnnotationExpr("Builder");

    }

    public static AnnotationExpr noArgsConstructor() {

        return new MarkerAnnotationExpr("NoArgsConstructor");

    }

    public static AnnotationExpr allArgsConstructor() {

        return new MarkerAnnotationExpr("AllArgsConstructor");

    }

    public static AnnotationExpr requiredArgsConstructor() {

        return new MarkerAnnotationExpr("RequiredArgsConstructor");

    }

    public static AnnotationExpr service() {

        return new MarkerAnnotationExpr("Service");

    }

    public static AnnotationExpr table(String tableName) {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("Table");

        annotation.addPair(
                "name",
                new StringLiteralExpr(tableName)
        );

        return annotation;

    }

    public static AnnotationExpr id() {

        return new MarkerAnnotationExpr("Id");

    }
    public static AnnotationExpr generatedValueIdentity() {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("GeneratedValue");

        annotation.addPair(
                "strategy",
                new FieldAccessExpr(
                        new NameExpr("GenerationType"),
                        "IDENTITY"
                )
        );

        return annotation;

    }
}