package com.cloudlabjp.cli.generator.feature.create;

import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.generator.factory.MethodFactory;

import java.nio.file.Path;

public class CreateFeatureGenerator {

    public void generate(Path serviceFile) {

        JavaSourceEditor editor =
                new JavaSourceEditor(serviceFile);

        if (editor.classEditor().hasMethod("create")) {
            return;
        }

        String entityName =
                editor.getClassName();

        editor.classEditor()
                .addMethod(
                        MethodFactory.createMethod(entityName)
                );

        editor.save();

    }

}