package com.cloudlabjp.cli.editor;

import com.github.javaparser.ast.CompilationUnit;

public class ImportEditor {

    private final CompilationUnit unit;

    public ImportEditor(CompilationUnit unit) {
        this.unit = unit;
    }

    public ImportEditor add(String importName) {

        unit.addImport(importName);

        return this;

    }

}