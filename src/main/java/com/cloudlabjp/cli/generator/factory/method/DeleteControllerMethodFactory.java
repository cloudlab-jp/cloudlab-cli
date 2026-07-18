package com.cloudlabjp.cli.generator.factory.method;

import com.cloudlabjp.cli.ast.method.MethodAstBuilder;
import com.cloudlabjp.cli.editor.annotation.JavaAnnotation;
import com.github.javaparser.ast.body.MethodDeclaration;

public final class DeleteControllerMethodFactory {

    private DeleteControllerMethodFactory() {
    }

    public static MethodDeclaration build() {

        return new MethodAstBuilder()

                .publicMethod()

                .annotation(
                        JavaAnnotation.deleteMapping("/{id}")
                )

                .name("delete")

                .returnType("ResponseEntity<Void>")

                .parameter(
                        "Long",
                        "id",
                        JavaAnnotation.pathVariable()
                )

                .body("""
                        service.delete(id);

                        return ResponseEntity.noContent().build();
                        """)

                .build();

    }

}