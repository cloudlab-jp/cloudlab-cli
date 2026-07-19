package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class UpdateControllerMethodFactory {

    private UpdateControllerMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .annotation(
                        JavaAnnotation.putMapping("/{id}")
                )

                .name("update")

                .returnType(
                        "ResponseEntity<"
                                + entityName
                                + "Response>"
                )

                .parameter(
                        "Long",
                        "id",
                        JavaAnnotation.pathVariable()
                )

                .parameter(
                        "Update" + entityName + "Request",
                        "request",
                        JavaAnnotation.valid(),
                        JavaAnnotation.requestBody()
                )

                .body("""
                        return ResponseEntity.ok(
                                service.update(id, request)
                        );
                        """)

                .build();

    }

}