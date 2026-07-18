package com.cloudlabjp.cli.generator.service;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;

import java.nio.file.Path;

public class ServiceConfigurer {

    public void configure(Path file) {

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        CompilationUnitEditor unit =
                editor.editor();

        unit.imports()

                .add("org.springframework.stereotype.Service")

                .add("lombok.RequiredArgsConstructor");

        unit.clazz()

                .service()

                .configure();

        editor.save();

    }

}