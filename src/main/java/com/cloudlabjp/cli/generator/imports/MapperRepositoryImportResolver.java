package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MapperRepositoryImportResolver {

    public Set<String> resolve(
            String basePackage,
            String module,
            List<FieldDefinition> fields
    ) {

        String base =
                basePackage
                        + ".modules."
                        + module;

        Set<String> imports =
                new LinkedHashSet<>();

        for (FieldDefinition field : fields) {

            if (field.kind() == FieldKind.MANY_TO_ONE
                    || field.kind() == FieldKind.ONE_TO_ONE
                    || field.kind() == FieldKind.MANY_TO_MANY) {

                imports.add(
                        "import "
                                + base
                                + ".domain.repository."
                                + field.type()
                                + "Repository;"
                );

            }

        }

        return imports;

    }

}