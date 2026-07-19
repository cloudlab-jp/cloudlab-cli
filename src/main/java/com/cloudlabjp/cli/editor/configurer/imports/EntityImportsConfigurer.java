package com.cloudlabjp.cli.editor.configurer.imports;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.generator.imports.EntityImportResolver;
import com.cloudlabjp.cli.generator.imports.JpaImportResolver;
import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class EntityImportsConfigurer {

    private final EntityImportResolver entityImports =
            new EntityImportResolver();

    private final JpaImportResolver jpaImports =
            new JpaImportResolver();

    public void configure(
            CompilationUnitEditor unit,
            List<FieldDefinition> fields
    ) {

        entityImports.resolve()

                .forEach(unit.imports()::add);

        jpaImports.resolve(fields)

                .forEach(unit.imports()::add);

    }

}