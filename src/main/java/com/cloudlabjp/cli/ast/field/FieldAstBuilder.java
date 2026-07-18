package com.cloudlabjp.cli.ast.field;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AnnotationExpr;

public class FieldAstBuilder {

    private final FieldDeclaration field =
            new FieldDeclaration();

    private final VariableDeclarator variable =
            new VariableDeclarator();

    public FieldAstBuilder privateField() {

        field.addModifier(
                Modifier.Keyword.PRIVATE
        );

        return this;

    }

    public FieldAstBuilder type(String type) {

        variable.setType(type);

        return this;

    }

    public FieldAstBuilder name(String name) {

        variable.setName(name);

        return this;

    }

    public FieldAstBuilder annotate(
            AnnotationExpr annotation
    ) {

        field.addAnnotation(annotation);

        return this;

    }

    public FieldDeclaration build() {

        field.addVariable(variable);

        return field;

    }

}