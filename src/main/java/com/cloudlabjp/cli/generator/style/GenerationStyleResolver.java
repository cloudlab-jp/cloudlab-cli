package com.cloudlabjp.cli.generator.style;

import com.cloudlabjp.cli.config.EntityStyle;
import com.cloudlabjp.cli.config.GeneratorConfiguration;
import com.cloudlabjp.cli.generator.builder.LombokBuilder;
import com.cloudlabjp.cli.generator.imports.MapperImportResolver;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ImportResolver;
import com.cloudlabjp.cli.generator.imports.JavaTypeImportResolver;

import java.util.List;

public class GenerationStyleResolver {

    private final GeneratorConfiguration configuration;

    private final ImportResolver importResolver =
            new ImportResolver();

    private final LombokBuilder lombokBuilder =
            new LombokBuilder();

    private final JavaTypeImportResolver javaTypeImports =
            new JavaTypeImportResolver();

    private final MapperImportResolver mapperImports =
            new MapperImportResolver();

    public GenerationStyleResolver(ProjectInfo project) {

        this.configuration =
                new GeneratorConfiguration(
                        project.projectRoot()
                );

    }

    public String entityImports(List<FieldDefinition> fields) {

        String imports =
                importResolver.resolve(fields);

        if (configuration.entityStyle() == EntityStyle.LOMBOK) {

            if (!imports.isBlank()) {
                imports += System.lineSeparator();
            }

            imports += lombokBuilder.buildEntityImports();

        }

        return imports;

    }

    public String entityAnnotations() {

        if (configuration.entityStyle() == EntityStyle.LOMBOK) {

            return lombokBuilder.buildEntityAnnotations();

        }

        return "";

    }

    public boolean useLombok() {

        return configuration.entityStyle() == EntityStyle.LOMBOK;

    }

    public String requestDtoImports(List<FieldDefinition> fields) {

        StringBuilder builder = new StringBuilder();

        javaTypeImports.resolve(fields)
                .forEach(importValue ->
                        builder.append("import ")
                                .append(importValue)
                                .append(";")
                                .append(System.lineSeparator()));

        boolean hasNotBlank = false;

        boolean hasNotNull = false;

        for (FieldDefinition field : fields) {

            if (!field.required()) {
                continue;
            }

            if ("String".equals(field.type())) {

                hasNotBlank = true;

            } else {

                hasNotNull = true;

            }

        }

        if (hasNotBlank) {

            builder.append(
                    "import jakarta.validation.constraints.NotBlank;"
            ).append(System.lineSeparator());

        }

        if (hasNotNull) {

            builder.append(
                    "import jakarta.validation.constraints.NotNull;"
            ).append(System.lineSeparator());

        }

        if (useLombok()) {

            if (!builder.isEmpty()) {
                builder.append(System.lineSeparator());
            }

            builder.append(
                    lombokBuilder.buildDtoImports()
            );

        }

        return builder.toString();

    }

    public String mapperImports(
            String basePackage,
            String module,
            String entityName,
            List<FieldDefinition> fields
    ) {

        return mapperImports.resolve(
                basePackage,
                module,
                entityName,
                fields
        );

    }

    public String responseDtoImports(
            List<FieldDefinition> fields
    ) {

        StringBuilder builder = new StringBuilder();

        javaTypeImports.resolve(fields)
                .forEach(importValue ->
                        builder.append("import ")
                                .append(importValue)
                                .append(";")
                                .append(System.lineSeparator()));

        if (useLombok()) {

            if (!builder.isEmpty()) {
                builder.append(System.lineSeparator());
            }

            builder.append(
                    lombokBuilder.buildDtoImports()
            );

        }

        return builder.toString();

    }

    public String dtoAnnotations() {

        if (useLombok()) {

            return lombokBuilder.buildDtoAnnotations();

        }

        return "";

    }

    public String mapperAnnotations(
            List<FieldDefinition> fields
    ) {

        boolean hasRelations = fields.stream().anyMatch(field ->
                field.kind() == FieldKind.MANY_TO_ONE
                        || field.kind() == FieldKind.ONE_TO_ONE
                        || field.kind() == FieldKind.MANY_TO_MANY
        );

        if (!hasRelations) {
            return "";
        }

        return """
            @RequiredArgsConstructor
            @Component
            """;

    }

    public String mapperRepositories(
            List<FieldDefinition> fields
    ) {

        StringBuilder builder = new StringBuilder();

        for (FieldDefinition field : fields) {

            if (!isRelationship(field)) {
                continue;
            }

            builder.append("    private final ")
                    .append(field.type())
                    .append("Repository ")
                    .append(Character.toLowerCase(field.type().charAt(0)))
                    .append(field.type().substring(1))
                    .append("Repository;")
                    .append(System.lineSeparator())
                    .append(System.lineSeparator());

        }

        return builder.toString();

    }

    private boolean isRelationship(FieldDefinition field) {

        return switch (field.kind()) {

            case MANY_TO_ONE,
                 ONE_TO_ONE,
                 MANY_TO_MANY -> true;

            default -> false;

        };

    }



}