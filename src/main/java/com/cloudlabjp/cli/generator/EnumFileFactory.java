package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;

public class EnumFileFactory {

    public GeneratedFile create(
            ProjectInfo project,
            String module,
            String enumName
    ) {

        String basePackage =
                project.basePackage();

        String content = """
                package %s.modules.%s.domain.model;

                public enum %s {

                    VALUE1,
                    VALUE2

                }
                """.formatted(
                basePackage,
                module,
                enumName
        );

        return new GeneratedFile(
                "domain/model/" + enumName + ".java",
                content
        );

    }

}