package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.generator.body.mapper.MapperAssignmentGenerator;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.util.List;

public final class UpdateMapperMethodFactory {

    private static final MapperAssignmentGenerator generator =
            new MapperAssignmentGenerator();

    private UpdateMapperMethodFactory() {
    }

    public static MethodDeclaration build(
            String entityName,
            List<FieldDefinition> fields
    ) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("update")

                .returnType("void")

                .parameter(
                        entityName,
                        "entity"
                )

                .parameter(
                        "Update" + entityName + "Request",
                        "request"
                )

                .body(
                        generator.updateEntity(entityName,
                                fields)
                )

                .build();

    }

}