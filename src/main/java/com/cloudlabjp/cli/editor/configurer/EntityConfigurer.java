package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;

public class EntityConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            String entityName
    ) {

        unit.clazz()

                .entity()

                .configure(
                        entityName.toLowerCase()
                );

    }

}