package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.util.StringUtils;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class FindByRelationMethodFactory {

    private FindByRelationMethodFactory() {
    }

    public static MethodDeclaration build(
            String entityName,
            FieldDefinition field
    ) {

        return new MethodAstBuilder()

                .inInterface()

                .name(
                        "findBy"
                                + StringUtils.capitalize(field.name())
                )

                .returnType(
                        "List<"
                                + entityName
                                + ">"
                )

                .parameter(
                        field.type(),
                        field.name()
                )

                .build();

    }

}