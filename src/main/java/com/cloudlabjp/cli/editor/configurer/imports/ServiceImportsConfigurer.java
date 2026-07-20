package com.cloudlabjp.cli.editor.configurer.imports;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;

public class ServiceImportsConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            String basePackage,
            String module,
            String entity
    ) {

        unit.imports()

                .add("org.springframework.stereotype.Service")

                .add("lombok.RequiredArgsConstructor")

                .add(
                        basePackage
                                + ".modules."
                                + module
                                + ".domain.repository."
                                + entity
                                + "Repository"
                )

                .add(
                        basePackage
                                + ".modules."
                                + module
                                + ".application.mapper."
                                + entity
                                + "Mapper"
                )

                .add(
                        basePackage
                                + ".modules."
                                + module
                                + ".application.dto.Create"
                                + entity
                                + "Request"
                )

                .add(
                        basePackage
                                + ".modules."
                                + module
                                + ".application.dto.Update"
                                + entity
                                + "Request"
                )

                .add(
                        basePackage
                                + ".modules."
                                + module
                                + ".application.dto."
                                + entity
                                + "Response"
                )

                .add(
                        basePackage
                                + ".modules."
                                + module
                                + ".domain.model."
                                + entity
                )

                .add("java.util.List");

    }

}