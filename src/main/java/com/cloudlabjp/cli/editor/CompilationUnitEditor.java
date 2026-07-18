package com.cloudlabjp.cli.editor;

import com.github.javaparser.ast.CompilationUnit;

public class CompilationUnitEditor {

    private final CompilationUnit compilationUnit;

    public CompilationUnitEditor(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public ImportEditor imports() {

        return new ImportEditor(compilationUnit);

    }

    public ClassEditor clazz() {

        return new ClassEditor(

                compilationUnit

                        .getPrimaryType()

                        .orElseThrow()

                        .asClassOrInterfaceDeclaration()

        );

    }

}