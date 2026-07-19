package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;

import java.nio.file.Path;

public class ControllerConfigurer {

    public void configure(Path file,
                          String basePackage,
                          String moduleName,
                          String entityName) {

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        CompilationUnitEditor unit =
                editor.editor();

        unit.imports()

                .add("org.springframework.http.ResponseEntity")

                .add("org.springframework.web.bind.annotation.RestController")

                .add("org.springframework.web.bind.annotation.RequestMapping")

                .add("org.springframework.web.bind.annotation.PostMapping")

                .add("org.springframework.web.bind.annotation.RequestBody")

                .add("lombok.RequiredArgsConstructor")

                .add("org.springframework.web.bind.annotation.GetMapping")

                .add("org.springframework.web.bind.annotation.PutMapping")

                .add("org.springframework.web.bind.annotation.DeleteMapping")

                .add("org.springframework.web.bind.annotation.PathVariable")

                .add("java.util.List")

                .add("jakarta.validation.Valid")

                .add(basePackage
                        + ".modules."
                        + moduleName
                        + ".application.service."
                        + entityName
                        + "Service")

                .add(basePackage
                        + ".modules."
                        + moduleName
                        + ".application.dto.Create"
                        + entityName
                        + "Request")

                .add(basePackage
                        + ".modules."
                        + moduleName
                        + ".application.dto.Update"
                        + entityName
                        + "Request")

                .add(basePackage
                        + ".modules."
                        + moduleName
                        + ".application.dto."
                        + entityName
                        + "Response");

        unit.clazz()

                .controller()

                .configure(
                        "/" + entityName.toLowerCase()
                );

        unit.clazz()

                .controller()

                .addDependency(
                        entityName + "Service",
                        "service"
                );

        editor.save();

    }

}