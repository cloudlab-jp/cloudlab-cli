package com.cloudlabjp.cli.editor.configurer.imports;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;

public class ServiceImportsConfigurer {

    public void configure(CompilationUnitEditor unit) {

        unit.imports()

                .add("org.springframework.stereotype.Service")

                .add("lombok.RequiredArgsConstructor");

    }

}