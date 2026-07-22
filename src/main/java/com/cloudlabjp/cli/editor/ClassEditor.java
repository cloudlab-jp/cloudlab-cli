package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.editor.relationship.ManyToManyEditor;
import com.cloudlabjp.cli.editor.relationship.OneToManyEditor;
import com.cloudlabjp.cli.editor.relationship.OneToOneEditor;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class ClassEditor {

    private final ClassOrInterfaceDeclaration clazz;

    public ClassEditor(ClassOrInterfaceDeclaration clazz) {
        this.clazz = clazz;
    }

    public void addMethod(MethodDeclaration method) {

        clazz.addMember(method);

    }

    public void replaceMethod(MethodDeclaration method) {

        clazz.getMethods()

                .stream()

                .filter(existing ->
                        existing.getSignature()
                                .equals(method.getSignature()))

                .findFirst()

                .ifPresent(MethodDeclaration::remove);

        clazz.addMember(method);

    }

    public AnnotationEditor annotations() {

        return new AnnotationEditor(clazz);

    }

    public FieldEditor fields() {

        return new FieldEditor(clazz);

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

    public EntityEditor entity() {

        return new EntityEditor(this);

    }

    public boolean hasField(String name) {

        return clazz.getFields()

                .stream()

                .flatMap(field -> field.getVariables().stream())

                .anyMatch(variable ->
                        variable.getNameAsString().equals(name));

    }

    public boolean hasAnnotation(String annotation) {

        return clazz.getAnnotations()

                .stream()

                .anyMatch(a ->
                        a.getNameAsString().equals(annotation));

    }

    public ServiceEditor service() {

        return new ServiceEditor(this);

    }

    public ControllerEditor controller() {

        return new ControllerEditor(this);

    }

    public OneToManyEditor oneToMany() {

        return new OneToManyEditor(this);

    }

    public OneToOneEditor oneToOne() {

        return new OneToOneEditor(this);

    }

    public RepositoryEditor repository() {

        return new RepositoryEditor(this);

    }

    ClassOrInterfaceDeclaration declaration() {

        return clazz;

    }

    public ManyToManyEditor manyToMany() {

        return new ManyToManyEditor(this);

    }

}