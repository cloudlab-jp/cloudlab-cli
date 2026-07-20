package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.builder.EntitySourceBuilder;
import com.cloudlabjp.cli.generator.builder.FieldTarget;
import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.generator.style.GenerationStyleResolver;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.ResourceTemplateEngine;
import com.cloudlabjp.cli.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityFileFactory {

    private final ResourceTemplateEngine templateEngine =
            new ResourceTemplateEngine();

    private final EntitySourceBuilder sourceBuilder =
            new EntitySourceBuilder();

    public List<GeneratedFile> create(ProjectInfo project,
                                      String module,
                                      String entity,
                                      List<FieldDefinition> fields) {

        GenerationStyleResolver styleResolver =
                new GenerationStyleResolver(project);

        String className =
                StringUtils.capitalize(entity);

        Map<String, String> variables =
                new HashMap<>();

        variables.put("basePackage", project.basePackage());
        variables.put("module", module);
        variables.put("className", className);

        variables.put(
                "annotations",
                styleResolver.entityAnnotations()
        );

        if (styleResolver.useLombok()) {

            variables.put("constructor", "");
            variables.put("getters", "");
            variables.put("setters", "");

        } else {

            variables.put(
                    "constructor",
                    sourceBuilder.buildConstructor(
                            className,
                            fields
                    )
            );

            variables.put(
                    "getters",
                    sourceBuilder.buildGetters(fields)
            );

            variables.put(
                    "setters",
                    sourceBuilder.buildSetters(fields)
            );

        }

        Map<String, String> entityVariables =
                new HashMap<>(variables);

        entityVariables.put(
                "imports",
                styleResolver.entityImports(fields)
        );

        entityVariables.put(
                "fields",
                sourceBuilder.buildFields(
                        fields,
                        FieldTarget.ENTITY
                )
        );

        Map<String, String> createVariables =
                new HashMap<>(variables);

        createVariables.put(
                "imports",
                styleResolver.requestDtoImports(fields)
        );

        createVariables.put(
                "fields",
                sourceBuilder.buildFields(
                        fields,
                        FieldTarget.CREATE_REQUEST
                )
        );

        Map<String, String> updateVariables =
                new HashMap<>(variables);

        updateVariables.put(
                "imports",
                styleResolver.requestDtoImports(fields)
        );

        updateVariables.put(
                "fields",
                sourceBuilder.buildFields(
                        fields,
                        FieldTarget.UPDATE_REQUEST
                )
        );

        Map<String, String> responseVariables =
                new HashMap<>(variables);

        responseVariables.put(
                "imports",
                styleResolver.responseDtoImports(fields)
        );

        responseVariables.put(
                "fields",
                sourceBuilder.buildFields(
                        fields,
                        FieldTarget.RESPONSE
                )
        );

        Map<String, String> mapperVariables =
                new HashMap<>(variables);

        mapperVariables.put(
                "imports",
                styleResolver.mapperImports(
                        project.basePackage(),
                        module,
                        className
                )
        );

        return List.of(

                new GeneratedFile(
                        "domain/model/" + className + ".java",
                        templateEngine.render(
                                "entity.java.tpl",
                                entityVariables
                        )
                ),

                new GeneratedFile(
                        "application/dto/Create" + className + "Request.java",
                        templateEngine.render(
                                "create-request.java.tpl",
                                createVariables
                        )
                ),

                new GeneratedFile(
                        "application/dto/Update" + className + "Request.java",
                        templateEngine.render(
                                "update-request.java.tpl",
                                updateVariables
                        )
                ),

                new GeneratedFile(
                        "application/dto/" + className + "Response.java",
                        templateEngine.render(
                                "response.java.tpl",
                                responseVariables
                        )
                ),

                new GeneratedFile(
                        "application/mapper/" + className + "Mapper.java",
                        templateEngine.render(
                                "mapper.java.tpl",
                                mapperVariables
                        )
                )

        );

    }

}