package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class FindAllControllerMethodFactory {

    private FindAllControllerMethodFactory() {
    }

    public static MethodDeclaration build(String entityName) {

        return new MethodAstBuilder()

                .publicMethod()

                .annotation(
                        JavaAnnotation.getMapping()
                )

                .name("findAll")

                .returnType(
                        "ResponseEntity<List<"
                                + entityName
                                + "Response>>"
                )

                .body("""
                        return ResponseEntity.ok(
                                service.findAll()
                        );
                        """)

                .build();

    }

}