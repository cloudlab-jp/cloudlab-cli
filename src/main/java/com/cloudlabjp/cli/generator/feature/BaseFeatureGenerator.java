package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.nio.file.Path;

public abstract class BaseFeatureGenerator {

    protected void addMethod(Path file,
                             String methodName,
                             MethodDeclaration method) {

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        if (editor.classEditor().hasMethod(methodName)) {
            return;
        }

        editor.classEditor()
                .addMethod(method);

        editor.save();

    }

}