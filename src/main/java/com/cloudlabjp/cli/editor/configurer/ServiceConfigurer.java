package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.editor.configurer.imports.ServiceImportsConfigurer;

import java.nio.file.Path;

public class ServiceConfigurer {

    private final ServiceImportsConfigurer imports =
            new ServiceImportsConfigurer();

    public void configure(
            Path file,
            String basePackage,
            String module,
            String entity
    ) {

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        CompilationUnitEditor unit =
                editor.editor();

        imports.configure(
                unit,
                basePackage,
                module,
                entity
        );

        unit.clazz()

                .service()

                .configure();

        unit.clazz()

                .service()

                .addDependency(
                        entity + "Repository",
                        "repository"
                );

        unit.clazz()

                .service()

                .addDependency(
                        entity + "Mapper",
                        "mapper"
                );

        editor.save();

    }

}