package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.util.List;

public class EnumFileFactory {

    public GeneratedFile create(
            ProjectInfo project,
            String module,
            String enumName,
            List<String> values
    ) {

        String basePackage =
                project.basePackage();

        String constants;

        if (values == null || values.isEmpty()) {

            constants = """
                    VALUE1,
                    VALUE2
                    """;

        } else {

            constants = String.join(
                    "," + System.lineSeparator() + "    ",
                    values
            );

        }

        String content = """
                package %s.modules.%s.domain.model;

                public enum %s {

                    %s

                }
                """.formatted(
                basePackage,
                module,
                enumName,
                constants
        );

        return new GeneratedFile(
                "domain/model/" + enumName + ".java",
                content
        );

    }

}