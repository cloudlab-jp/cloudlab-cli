package com.cloudlabjp.cli.ast.expression;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.Expression;

public final class ExpressionFactory {

    private ExpressionFactory() {
    }

    public static Expression of(String expression) {

        return StaticJavaParser.parseExpression(expression);

    }

}