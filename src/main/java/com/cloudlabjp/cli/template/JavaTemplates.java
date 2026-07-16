package com.cloudlabjp.cli.template;

import com.cloudlabjp.cli.util.StringUtils;

public final class JavaTemplates {

    private JavaTemplates() {
    }

    public static String controller(String basePackage, String module) {

        String className = className(module);

        return """
                package %s.modules.%s.infrastructure.controller;

                public class %sController {

                }
                """.formatted(basePackage, module, className);

    }

    public static String service(String basePackage, String module) {

        String className = className(module);

        return """
                package %s.modules.%s.application.service;

                public class %sService {

                }
                """.formatted(basePackage, module, className);

    }

    public static String entity(String basePackage, String module) {

        String className = className(module);

        return """
                package %s.modules.%s.domain.model;

                public class %s {

                }
                """.formatted(basePackage, module, className);

    }

    public static String repository(String basePackage, String module) {

        String className = className(module);

        return """
                package %s.modules.%s.domain.repository;

                public interface %sRepository {

                }
                """.formatted(basePackage, module, className);

    }

    private static String className(String module) {
        return StringUtils.capitalize(module);
    }

}