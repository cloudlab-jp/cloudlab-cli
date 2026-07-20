package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class CreateServiceMethodFactory {

    private CreateServiceMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("create")

                .returnType(entityName + "Response")

                .parameter(
                        "Create" + entityName + "Request",
                        "request"
                )

                .body(
                        """
                        var entity = mapper.toEntity(request);

                        entity = repository.save(entity);

                        return mapper.toResponse(entity);
                        """
                )

                .build();

    }

}