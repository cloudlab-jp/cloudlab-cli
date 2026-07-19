package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RepositoryImportResolver {

    public Set<String> resolve(
            ProjectInfo project,
            String module,
            String entity,
            List<FieldDefinition> fields
    ) {

        Set<String> imports = new LinkedHashSet<>();

        imports.add("java.util.List");

        imports.add(
                "org.springframework.data.jpa.repository.JpaRepository"
        );

        imports.add(
                project.basePackage()
                        + ".modules."
                        + module
                        + ".domain.model."
                        + entity
        );

        for (FieldDefinition field : fields) {

            if (field.kind() != FieldKind.SIMPLE) {

                imports.add(
                        project.basePackage()
                                + ".modules."
                                + module
                                + ".domain.model."
                                + field.type()
                );

            }

        }

        return imports;

    }

}