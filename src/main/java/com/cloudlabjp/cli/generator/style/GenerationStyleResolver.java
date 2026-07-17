package com.cloudlabjp.cli.generator.style;

import com.cloudlabjp.cli.config.EntityStyle;
import com.cloudlabjp.cli.config.GeneratorConfiguration;
import com.cloudlabjp.cli.generator.builder.LombokBuilder;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ImportResolver;

import java.util.List;

public class GenerationStyleResolver {

    private final GeneratorConfiguration configuration;

    private final ImportResolver importResolver =
            new ImportResolver();

    private final LombokBuilder lombokBuilder =
            new LombokBuilder();

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

}