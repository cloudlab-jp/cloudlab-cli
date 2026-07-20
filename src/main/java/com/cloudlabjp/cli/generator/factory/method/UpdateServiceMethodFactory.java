package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class UpdateServiceMethodFactory {

    private UpdateServiceMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .name("update")

                .returnType(entityName + "Response")

                .parameter(
                        "Long",
                        "id"
                )

                .parameter(
                        "Update" + entityName + "Request",
                        "request"
                )

                .body(
                        """
                        var entity = repository.findById(id)
                                .orElseThrow();

                        mapper.update(request, entity);

                        entity = repository.save(entity);

                        return mapper.toResponse(entity);
                        """
                )

                .build();

    }

}