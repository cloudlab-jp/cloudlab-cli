package com.cloudlabjp.cli.generator.style;

import com.cloudlabjp.cli.config.EntityStyle;
import com.cloudlabjp.cli.config.GeneratorConfiguration;
import com.cloudlabjp.cli.generator.builder.LombokBuilder;
import com.cloudlabjp.cli.generator.imports.MapperImportResolver;
import com.cloudlabjp.cli.model.FieldDefinition;
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

        return builder.toString();

    }

    public String mapperImports(
            String basePackage,
            String module,
            String entityName
    ) {

        return mapperImports.resolve(
                basePackage,
                module,
                entityName
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

        return builder.toString();

    }

}