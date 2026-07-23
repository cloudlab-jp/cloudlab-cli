package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MapperAnnotationImportResolver {

    public Set<String> resolve(
            List<FieldDefinition> fields
    ) {

        Set<String> imports =
                new LinkedHashSet<>();

        boolean hasRelations = fields.stream().anyMatch(field ->
                field.kind() == FieldKind.MANY_TO_ONE
                        || field.kind() == FieldKind.ONE_TO_ONE
                        || field.kind() == FieldKind.MANY_TO_MANY
        );

        if (hasRelations) {

            imports.add("import lombok.RequiredArgsConstructor;");
            imports.add("import org.springframework.stereotype.Component;");

        }

        return imports;

    }

}