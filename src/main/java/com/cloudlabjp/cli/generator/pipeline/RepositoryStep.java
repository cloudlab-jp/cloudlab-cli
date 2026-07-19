package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.editor.configurer.RepositoryConfigurer;
import com.cloudlabjp.cli.editor.configurer.RepositoryMethodConfigurer;
import com.cloudlabjp.cli.editor.configurer.imports.RepositoryImportsConfigurer;

public class RepositoryStep implements GeneratorStep {

    private final RepositoryImportsConfigurer imports =
            new RepositoryImportsConfigurer();

    private final RepositoryConfigurer repository =
            new RepositoryConfigurer();

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
                context.project(),
                context.module(),
                context.entityName(),
                context.fields()
        );

        repository.configure(
                unit,
                context.entityName()
        );

        methods.configure(
                unit,
                context.entityName(),
                context.fields()
        );

        editor.save();

    }

}