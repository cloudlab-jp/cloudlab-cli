package com.cloudlabjp.cli.generator.feature;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.nio.file.Path;

public abstract class BaseFeatureGenerator {

    protected void addMethod(Path file,
                             String methodName,
                             MethodDeclaration method) {

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        CompilationUnitEditor unit =
                editor.editor();

        if (unit.clazz().hasMethod(methodName)) {
            return;
        }

        unit.clazz()
                .addMethod(method);

        editor.save();

    }

}