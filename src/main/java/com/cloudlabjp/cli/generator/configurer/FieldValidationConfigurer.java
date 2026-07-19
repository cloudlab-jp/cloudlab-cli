package com.cloudlabjp.cli.generator.configurer;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.FieldDeclaration;

public class FieldValidationConfigurer {

    public void configure(
            FieldDeclaration declaration,
            FieldDefinition field
    ) {

        if (!field.required()) {
            return;
        }

        if ("String".equals(field.type())) {

            declaration.addAnnotation("NotBlank");

        } else {

            declaration.addAnnotation("NotNull");

        }

    }

}