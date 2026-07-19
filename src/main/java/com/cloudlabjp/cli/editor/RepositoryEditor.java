package com.cloudlabjp.cli.editor;

import com.github.javaparser.ast.body.MethodDeclaration;

public class RepositoryEditor {

    private final ClassEditor clazz;

    public RepositoryEditor(ClassEditor clazz) {
        this.clazz = clazz;
    }

    public void addMethod(MethodDeclaration method) {

        if (!clazz.hasMethod(method.getNameAsString())) {

            clazz.addMethod(method);

        }

    }

    public void configure(String entityName) {

        clazz.declaration()

                .addExtendedType(
                        "JpaRepository<" + entityName + ", Long>"
                );

    }

}