package com.cloudlabjp.cli.generator.imports;

import java.util.LinkedHashSet;
import java.util.Set;

public class MapperEntityImportResolver {

    public Set<String> resolve(
            String basePackage,
            String module,
            String entityName
    ) {

        String base =
                basePackage
                        + ".modules."
                        + module;

        Set<String> imports =
                new LinkedHashSet<>();

        imports.add(
                "import "
                        + base
                        + ".domain.model."
                        + entityName
                        + ";"
        );

        return imports;

    }

}