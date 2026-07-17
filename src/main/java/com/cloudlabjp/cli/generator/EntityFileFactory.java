package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.config.EntityStyle;
import com.cloudlabjp.cli.config.GeneratorConfiguration;
import com.cloudlabjp.cli.generator.builder.EntitySourceBuilder;
import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ImportResolver;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;
import com.cloudlabjp.cli.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityFileFactory {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    private final ImportResolver importResolver =
            new ImportResolver();

    private final EntitySourceBuilder sourceBuilder =
            new EntitySourceBuilder();

    public List<GeneratedFile> create(ProjectInfo project,
                                      String module,
                                      String entity,
                                      List<FieldDefinition> fields){

        GeneratorConfiguration configuration =
                new GeneratorConfiguration(
                        project.projectRoot()
                );

        String className = StringUtils.capitalize(entity);

        Map<String, String> variables = new HashMap<>();

        variables.put("basePackage", project.basePackage());
        variables.put(
                "imports",
                importResolver.resolve(fields)
        );
        variables.put("module", module);
        variables.put("className", className);
        variables.put("annotations", "");
        variables.put(
                "fields",
                sourceBuilder.buildFields(fields)
        );

        if (configuration.entityStyle() == EntityStyle.PLAIN) {

            variables.put(
                    "constructor",
                    sourceBuilder.buildConstructor(className, fields)
            );

        } else {

            variables.put("constructor", "");

        }

        variables.put(
                "getters",
                sourceBuilder.buildGetters(fields)
        );

        variables.put(
                "setters",
                sourceBuilder.buildSetters(fields)
        );

        return List.of(

                new GeneratedFile(
                        "domain/model/" + className + ".java",
                        templateEngine.render(
                                "entity.java.tpl",
                                variables
                        )
                ),

                new GeneratedFile(
                        "application/dto/Create" + className + "Request.java",
                        templateEngine.render(
                                "create-request.java.tpl",
                                variables
                        )
                ),

                new GeneratedFile(
                        "application/dto/Update" + className + "Request.java",
                        templateEngine.render(
                                "update-request.java.tpl",
                                variables
                        )
                ),

                new GeneratedFile(
                        "application/dto/" + className + "Response.java",
                        templateEngine.render(
                                "response.java.tpl",
                                variables
                        )
                ),

                new GeneratedFile(
                        "application/mapper/" + className + "Mapper.java",
                        templateEngine.render(
                                "mapper.java.tpl",
                                variables
                        )
                )

        );

    }

    private String buildFields(List<FieldDefinition> fields) {

        if (fields == null || fields.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (FieldDefinition field : fields) {

            builder.append("    private ")
                    .append(field.type())
                    .append(" ")
                    .append(field.name())
                    .append(";")
                    .append(System.lineSeparator());

        }

        return builder.toString();

    }

}