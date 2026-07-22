package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.editor.configurer.EntityConfigurer;
import com.cloudlabjp.cli.editor.configurer.FieldConfigurer;
import com.cloudlabjp.cli.editor.configurer.RelationshipConfigurer;
import com.cloudlabjp.cli.editor.configurer.imports.EntityImportsConfigurer;
import com.cloudlabjp.cli.editor.configurer.ValidationImportsConfigurer;
import com.cloudlabjp.cli.editor.configurer.imports.RelationshipImportsConfigurer;
import com.cloudlabjp.cli.model.FieldDefinition;

public class EntityJpaStep implements GeneratorStep {

    private final EntityImportsConfigurer imports =
            new EntityImportsConfigurer();

    private final EntityConfigurer entity =
            new EntityConfigurer();

    private final FieldConfigurer fields =
            new FieldConfigurer();

    private final ValidationImportsConfigurer validations =
            new ValidationImportsConfigurer();

    private final RelationshipConfigurer relationships =
            new RelationshipConfigurer();

    private final RelationshipImportsConfigurer relationshipImports =
            new RelationshipImportsConfigurer();

    @Override
    public void execute(GenerationContext context) {

        JavaSourceEditor editor =
                new JavaSourceEditor(context.file());

        CompilationUnitEditor unit =
                editor.editor();

        imports.configure(
                unit,
                context.fields()
        );

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
        context.entityName(),
        context.fields()
);

        relationships.configure(
                unit,
                context.fields()
        );

        for (FieldDefinition field : context.fields()) {

            relationshipImports.configure(
                    unit,
                    field.kind()
            );

        }

        editor.save();

    }

}