package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.editor.configurer.EntityConfigurer;
import com.cloudlabjp.cli.editor.configurer.FieldConfigurer;
import com.cloudlabjp.cli.editor.configurer.imports.EntityImportsConfigurer;
import com.cloudlabjp.cli.editor.configurer.ValidationImportsConfigurer;

public class EntityJpaStep implements GeneratorStep {

    private final EntityImportsConfigurer imports =
            new EntityImportsConfigurer();

    private final EntityConfigurer entity =
            new EntityConfigurer();

    private final FieldConfigurer fields =
            new FieldConfigurer();

    private final ValidationImportsConfigurer validations =
            new ValidationImportsConfigurer();

    @Override
    public void execute(GenerationContext context) {

        JavaSourceEditor editor =
                new JavaSourceEditor(context.file());

        CompilationUnitEditor unit =
                editor.editor();

        imports.configure(unit);

        validations.configure(
                unit,
                context.fields()
        );

        entity.configure(
                unit,
                context.entityName()
        );

        fields.configure(
                unit,
                context.fields()
        );

        editor.save();

    }

}