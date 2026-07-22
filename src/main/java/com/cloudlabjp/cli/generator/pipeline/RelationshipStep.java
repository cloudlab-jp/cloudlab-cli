package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.editor.configurer.imports.RelationshipImportsConfigurer;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.project.EntityFinder;

import java.nio.file.Path;

public class RelationshipStep implements GeneratorStep {

    private final EntityFinder entityFinder =
            new EntityFinder();

    private final RelationshipImportsConfigurer imports =
            new RelationshipImportsConfigurer();

    @Override
    public void execute(GenerationContext context) {

        for (FieldDefinition field : context.fields()) {

            switch (field.kind()) {

                case MANY_TO_ONE ->
                        configureOneToMany(context, field);

                case ONE_TO_ONE ->
                        configureOneToOne(context, field);
                case MANY_TO_MANY ->
                        configureManyToMany(context, field);
                default -> {
                }

            }

        }

    }

    private void configureOneToMany(
            GenerationContext context,
            FieldDefinition field
    ) {

        Path entityFile =
                entityFinder.findEntity(
                        context.project(),
                        field.type()
                );

        JavaSourceEditor editor =
                new JavaSourceEditor(entityFile);

        CompilationUnitEditor unit =
                editor.editor();

        imports.configure(
                unit,
                FieldKind.ONE_TO_MANY
        );

        unit.clazz()

                .oneToMany()

                .add(
                        context.entityName(),
                        field.name()
                );

        editor.save();

    }

    private void configureOneToOne(
            GenerationContext context,
            FieldDefinition field
    ) {

        Path entityFile =
                entityFinder.findEntity(
                        context.project(),
                        field.type()
                );

        JavaSourceEditor editor =
                new JavaSourceEditor(entityFile);

        CompilationUnitEditor unit =
                editor.editor();

        imports.configure(
                unit,
                FieldKind.ONE_TO_ONE
        );

        unit.clazz()

                .oneToOne()

                .add(
                        context.entityName(),
                        field.name()
                );

        editor.save();

    }

    private void configureManyToMany(
            GenerationContext context,
            FieldDefinition field
    ) {

        Path entityFile =
                entityFinder.findEntity(
                        context.project(),
                        field.type()
                );

        JavaSourceEditor editor =
                new JavaSourceEditor(entityFile);

        CompilationUnitEditor unit =
                editor.editor();

        imports.configure(
                unit,
                FieldKind.MANY_TO_MANY
        );

        unit.clazz()

                .manyToMany()

                .add(
                        context.entityName(),
                        field.name()
                );

        editor.save();

    }

}