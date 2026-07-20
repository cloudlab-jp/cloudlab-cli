package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.mapper.MapperAssignmentGenerator;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.util.List;

public final class CreateMapperMethodFactory {

    private static final MapperAssignmentGenerator bodyGenerator =
            new MapperAssignmentGenerator();

    private CreateMapperMethodFactory() {
    }

    public static MethodDeclaration build(
            String entityName,
            List<FieldDefinition> fields
    ) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("toEntity")

                .returnType(entityName)

                .parameter(
                        "Create" + entityName + "Request",
                        "request"
                )

                .body(
                        bodyGenerator.entityFromRequest(
                                entityName,
                                fields
                        )
                )

                .build();

    }

}