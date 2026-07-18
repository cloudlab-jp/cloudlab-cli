package com.cloudlabjp.cli.editor.annotation;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.Name;

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

    public static AnnotationExpr id() {

        return new MarkerAnnotationExpr("Id");

    }

    public static AnnotationExpr table(String table) {

        return new NormalAnnotationExpr(

                new Name("Table"),

                NodeList.nodeList(

                        new MemberValuePair(

                                "name",

                                new StringLiteralExpr(table)

                        )

                )

        );

    }

    public static AnnotationExpr generatedValueIdentity() {

        return new NormalAnnotationExpr(

                new Name("GeneratedValue"),

                NodeList.nodeList(

                        new MemberValuePair(

                                "strategy",

                                new FieldAccessExpr(

                                        new NameExpr("GenerationType"),

                                        "IDENTITY"

                                )

                        )

                )

        );

    }

}