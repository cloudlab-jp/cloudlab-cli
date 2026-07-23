package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MapperRelationshipImportResolver {

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

            switch (field.kind()) {

                case MANY_TO_ONE,
                     ONE_TO_ONE ->

                        imports.add(
                                "import "
                                        + base
                                        + ".domain.model."
                                        + field.type()
                                        + ";"
                        );

                case MANY_TO_MANY -> {

                    imports.add(
                            "import java.util.List;"
                    );

                    imports.add(
                            "import "
                                    + base
                                    + ".domain.model."
                                    + field.type()
                                    + ";"
                    );

                }

                default -> {
                }

            }

        }

        return imports;

    }

}