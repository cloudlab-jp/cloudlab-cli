package com.cloudlabjp.cli.editor.configurer.imports;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;

public class EntityImportsConfigurer {

    public void configure(CompilationUnitEditor unit) {

        unit.imports()

                .add("jakarta.persistence.Entity")

                .add("jakarta.persistence.Table")

                .add("jakarta.persistence.Id")

                .add("jakarta.persistence.GeneratedValue")

                .add("jakarta.persistence.GenerationType")

                .add("lombok.Getter")

                .add("lombok.Setter")

                .add("lombok.Builder")

                .add("lombok.NoArgsConstructor")

                .add("lombok.AllArgsConstructor");

    }

}