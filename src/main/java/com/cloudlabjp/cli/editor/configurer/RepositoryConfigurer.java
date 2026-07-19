package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;

public class RepositoryConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            String entityName
    ) {

        unit.clazz()

                .repository()

                .configure(entityName);

    }

}