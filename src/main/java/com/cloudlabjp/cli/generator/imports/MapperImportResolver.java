package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MapperImportResolver {

    public String resolve(
            String basePackage,
            String module,
            String entityName,
            List<FieldDefinition> fields
    ) {

        String base = basePackage
                + ".modules."
                + module;

        Set<String> imports = new LinkedHashSet<>();

        imports.add(
                "import " + base + ".application.dto.Create"
                        + entityName + "Request;"
        );

        imports.add(
                "import " + base + ".application.dto.Update"
                        + entityName + "Request;"
        );

        imports.add(
                "import " + base + ".application.dto."
                        + entityName + "Response;"
        );

        imports.add(
                "import " + base + ".domain.model."
                        + entityName + ";"
        );

        for (FieldDefinition field : fields) {

            if (field.kind() == FieldKind.MANY_TO_ONE
                    || field.kind() == FieldKind.ONE_TO_ONE) {

                imports.add(
                        "import " + base
                                + ".domain.model."
                                + field.type()
                                + ";"
                );

            }

        }

        return String.join(System.lineSeparator(), imports);

    }

}