package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class CreateControllerMethodFactory {

    private CreateControllerMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .annotation(JavaAnnotation.postMapping())

                .name("create")

                .returnType(
                        "ResponseEntity<"
                                + entityName
                                + "Response>"
                )

                .parameter(
                        "Create" + entityName + "Request",
                        "request",
                        JavaAnnotation.requestBody()
                )

                .body(
                        """
                        return ResponseEntity.ok(
                                service.create(request)
                        );
                        """
                )

                .build();

    }

}