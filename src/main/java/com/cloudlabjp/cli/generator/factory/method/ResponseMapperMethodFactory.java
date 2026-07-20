package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.mapper.ResponseMapperBodyGenerator;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.util.List;

public final class ResponseMapperMethodFactory {

    private static final ResponseMapperBodyGenerator bodyGenerator =
            new ResponseMapperBodyGenerator();

    private ResponseMapperMethodFactory() {
    }

    public static MethodDeclaration build(
            String entityName,
            List<FieldDefinition> fields
    ) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("toResponse")

                .returnType(entityName + "Response")

                .parameter(
                        entityName,
                        "entity"
                )

                .body(
                        bodyGenerator.generate(
                                entityName,
                                fields
                        )
                )

                .build();

    }

}