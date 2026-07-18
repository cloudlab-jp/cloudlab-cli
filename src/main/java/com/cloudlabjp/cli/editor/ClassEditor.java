package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.editor.converter.MethodDefinitionConverter;
import com.cloudlabjp.cli.model.MethodDefinition;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class ClassEditor {

    private final ClassOrInterfaceDeclaration clazz;

    public ClassEditor(ClassOrInterfaceDeclaration clazz) {
        this.clazz = clazz;
    }

    public void addMethod(MethodDefinition definition) {

        addMethod(
                MethodDefinitionConverter.convert(definition)
        );

    }

    public void addMethod(MethodDeclaration method) {

        clazz.addMember(method);

    }

    public String getClassName() {

        return clazz.getNameAsString();

    }

    public boolean hasMethod(String name) {

        return clazz.getMethods()
                .stream()
                .anyMatch(method ->
                        method.getNameAsString().equals(name));

    }

    public void addImport(String importName) {

        clazz.findCompilationUnit()
                .ifPresent(unit -> unit.addImport(importName));

    }

}