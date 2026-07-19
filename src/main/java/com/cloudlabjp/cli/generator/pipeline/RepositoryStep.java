package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.editor.configurer.RepositoryMethodConfigurer;
import com.cloudlabjp.cli.editor.configurer.imports.RepositoryImportsConfigurer;

public class RepositoryStep implements GeneratorStep {

    private final RepositoryImportsConfigurer imports =
            new RepositoryImportsConfigurer();

    private final RepositoryMethodConfigurer methods =
            new RepositoryMethodConfigurer();

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

        methods.configure(
                unit,
                context.entityName(),
                context.fields()
        );

        editor.save();

    }

}