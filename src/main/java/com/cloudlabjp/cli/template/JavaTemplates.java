package com.cloudlabjp.cli.template;

import com.cloudlabjp.cli.util.StringUtils;

public final class JavaTemplates {

    private JavaTemplates() {
    }

    public static String controller(String module) {

        String className = StringUtils.capitalize(module);

        return """
                package modules.%s.infrastructure.controller;

                public class %sController {

                }
                """.formatted(module, className);

    }

    public static String service(String module) {

        String className = StringUtils.capitalize(module);

        return """
                package modules.%s.application.service;

                public class %sService {

                }
                """.formatted(module, className);

    }

    public static String entity(String module) {

        String className = StringUtils.capitalize(module);

        return """
                package modules.%s.domain.model;

                public class %s {

                }
                """.formatted(module, className);

    }

    public static String repository(String module) {

        String className = StringUtils.capitalize(module);

        return """
                package modules.%s.domain.repository;

                public interface %sRepository {

                }
                """.formatted(module, className);

    }

}