package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MapperImportResolver {

    private final MapperAnnotationImportResolver annotationImports =
            new MapperAnnotationImportResolver();

    private final MapperDtoImportResolver dtoImports =
            new MapperDtoImportResolver();

    private final MapperEntityImportResolver entityImports =
            new MapperEntityImportResolver();

    private final MapperRelationshipImportResolver relationshipImports =
            new MapperRelationshipImportResolver();

    private final MapperRepositoryImportResolver repositoryImports =
            new MapperRepositoryImportResolver();

    public String resolve(
            String basePackage,
            String module,
            String entityName,
            List<FieldDefinition> fields
    ) {

        Set<String> imports =
                new LinkedHashSet<>();

        imports.addAll(
                annotationImports.resolve(fields)
        );

        imports.addAll(
                dtoImports.resolve(
                        basePackage,
                        module,
                        entityName
                )
        );

        imports.addAll(
                entityImports.resolve(
                        basePackage,
                        module,
                        entityName
                )
        );

        imports.addAll(
                relationshipImports.resolve(
                        basePackage,
                        module,
                        fields
                )
        );

        imports.addAll(
                repositoryImports.resolve(
                        basePackage,
                        module,
                        fields
                )
        );

        return String.join(
                System.lineSeparator(),
                imports
        );

    }

}