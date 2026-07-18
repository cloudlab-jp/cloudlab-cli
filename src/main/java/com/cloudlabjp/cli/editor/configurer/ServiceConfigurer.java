package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;

import java.nio.file.Path;

public class ServiceConfigurer {

    public void configure(Path file,
                          String basePackage,
                          String moduleName,
                          String entityName){

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        CompilationUnitEditor unit =
                editor.editor();

        unit.imports()

                .add("org.springframework.stereotype.Service")

                .add("lombok.RequiredArgsConstructor");

        unit.imports()

                .add(basePackage
                        + ".modules."
                        + moduleName
                        + ".domain.repository."
                        + entityName
                        + "Repository")

                .add(basePackage
                        + ".modules."
                        + moduleName
                        + ".application.mapper."
                        + entityName
                        + "Mapper");

        unit.clazz()

                .service()

                .configure();

        String entity = entityName;

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