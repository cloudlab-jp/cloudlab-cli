package com.cloudlabjp.cli.generator.imports;

import java.util.LinkedHashSet;
import java.util.Set;

public class MapperDtoImportResolver {

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
                "import " + base
                        + ".application.dto.Create"
                        + entityName
                        + "Request;"
        );

        imports.add(
                "import " + base
                        + ".application.dto.Update"
                        + entityName
                        + "Request;"
        );

        imports.add(
                "import " + base
                        + ".application.dto."
                        + entityName
                        + "Response;"
        );

        return imports;

    }

}