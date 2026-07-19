package com.cloudlabjp.cli.editor.configurer.imports;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.generator.imports.RepositoryImportResolver;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.util.List;

public class RepositoryImportsConfigurer {

    private final RepositoryImportResolver resolver =
            new RepositoryImportResolver();

    public void configure(
            CompilationUnitEditor unit,
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields
    ) {

        resolver.resolve(
                        project,
                        module,
                        entity,
                        fields
                )

                .forEach(unit.imports()::add);

    }

}