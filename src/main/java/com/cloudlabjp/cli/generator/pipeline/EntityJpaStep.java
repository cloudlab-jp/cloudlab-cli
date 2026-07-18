package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;

import java.nio.file.Path;

public class EntityJpaStep
        implements GeneratorStep {

    @Override
    public void execute(Path file) {

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        CompilationUnitEditor unit =
                editor.editor();

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

        unit.clazz()

                .entity()

                .configure(
                        unit.clazz()
                                .getClassName()
                                .toLowerCase()
                );

        editor.save();

    }

}