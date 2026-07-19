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

    public static AnnotationExpr restController() {

        return new MarkerAnnotationExpr("RestController");

    }

    public static AnnotationExpr requestMapping(String path) {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("RequestMapping");

        annotation.addPair(
                "value",
                new StringLiteralExpr(path)
        );

        return annotation;

    }

    public static AnnotationExpr requestBody() {

        return new MarkerAnnotationExpr("RequestBody");

    }

    public static AnnotationExpr pathVariable() {

        return new MarkerAnnotationExpr("PathVariable");

    }

    public static AnnotationExpr getMapping() {

        return new MarkerAnnotationExpr("GetMapping");

    }

    public static AnnotationExpr postMapping() {

        return new MarkerAnnotationExpr("PostMapping");

    }

    public static AnnotationExpr getMapping(String path) {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("GetMapping");

        annotation.addPair(
                "value",
                new StringLiteralExpr(path)
        );

        return annotation;

    }

    public static AnnotationExpr putMapping(String path) {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("PutMapping");

        annotation.addPair(
                "value",
                new StringLiteralExpr(path)
        );

        return annotation;

    }

    public static AnnotationExpr deleteMapping(String path) {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("DeleteMapping");

        annotation.addPair(
                "value",
                new StringLiteralExpr(path)
        );

        return annotation;

    }

    public static AnnotationExpr valid() {
        return new MarkerAnnotationExpr("Valid");
    }

    public static AnnotationExpr manyToOneLazy() {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("ManyToOne");

        annotation.addPair(
                "fetch",
                new FieldAccessExpr(
                        new NameExpr("FetchType"),
                        "LAZY"
                )
        );

        return annotation;

    }

    public static AnnotationExpr joinColumn(String columnName) {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("JoinColumn");

        annotation.addPair(
                "name",
                new StringLiteralExpr(columnName)
        );

        return annotation;

    }

    public static AnnotationExpr oneToMany(String mappedBy) {

        NormalAnnotationExpr annotation =
                new NormalAnnotationExpr();

        annotation.setName("OneToMany");

        annotation.addPair(
                "mappedBy",
                new StringLiteralExpr(mappedBy)
        );

        annotation.addPair(
                "cascade",
                new FieldAccessExpr(
                        new NameExpr("CascadeType"),
                        "ALL"
                )
        );

        annotation.addPair(
                "orphanRemoval",
                new BooleanLiteralExpr(true)
        );

        return annotation;

    }
}