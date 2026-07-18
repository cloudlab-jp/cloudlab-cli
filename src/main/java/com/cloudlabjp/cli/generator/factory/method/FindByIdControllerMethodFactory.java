package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class FindByIdControllerMethodFactory {

    private FindByIdControllerMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .annotation(
                        JavaAnnotation.getMapping("/{id}")
                )

                .name("findById")

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

                .body("""
                        return ResponseEntity.ok(
                                service.findById(id)
                        );
                        """)

                .build();

    }

}