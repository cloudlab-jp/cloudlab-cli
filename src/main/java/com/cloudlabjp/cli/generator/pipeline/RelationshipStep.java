package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.project.EntityFinder;

import java.nio.file.Path;

public class RelationshipStep implements GeneratorStep {

    private final EntityFinder entityFinder =
            new EntityFinder();

    @Override
    public void execute(GenerationContext context) {

        for (FieldDefinition field : context.fields()) {

            if (field.kind() != FieldKind.MANY_TO_ONE) {
                continue;
            }

            Path entityFile =
                    entityFinder.findEntity(
                            context.project(),
                            field.type()
                    );

            JavaSourceEditor editor =
                    new JavaSourceEditor(entityFile);

            CompilationUnitEditor unit =
                    editor.editor();

            unit.clazz()

                    .oneToMany()

                    .add(
                            context.entityName(),
                            field.name()
                    );

            editor.save();

        }

    }

}