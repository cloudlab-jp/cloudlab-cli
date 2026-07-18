package com.cloudlabjp.cli.ast.statement;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.stmt.Statement;

public final class StatementFactory {

    private StatementFactory() {
    }

    public static Statement of(String code) {

        return StaticJavaParser.parseStatement(code);

    }

}