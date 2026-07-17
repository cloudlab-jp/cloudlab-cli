package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
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

    public List<GeneratedFile> create(ProjectInfo project,
                                      String module,
                                      String entity,
                                      List<FieldDefinition> fields){

        String className = StringUtils.capitalize(entity);

        Map<String, String> variables = new HashMap<>();

        variables.put("basePackage", project.basePackage());
        variables.put("module", module);
        variables.put("className", className);
        variables.put("fields", buildFields(fields));
        System.out.println("FIELDS:");
        System.out.println(variables.get("fields"));

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