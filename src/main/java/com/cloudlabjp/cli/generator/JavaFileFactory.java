package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;
import com.cloudlabjp.cli.template.JavaTemplates;
import com.cloudlabjp.cli.util.StringUtils;

import java.util.List;

public class JavaFileFactory {

    public List<GeneratedFile> create(ProjectInfo project,
                                      String module) {

        String className = StringUtils.capitalize(module);

        return List.of(

                new GeneratedFile(
                        "application/service/" + className + "Service.java",
                        JavaTemplates.service(project.basePackage(), module)
                ),

                new GeneratedFile(
                        "domain/model/" + className + ".java",
                        JavaTemplates.entity(project.basePackage(), module)
                ),

                new GeneratedFile(
                        "domain/repository/" + className + "Repository.java",
                        JavaTemplates.repository(project.basePackage(), module)
                ),

                new GeneratedFile(
                        "infrastructure/controller/" + className + "Controller.java",
                        JavaTemplates.controller(project.basePackage(), module)
                )

        );

    }

}