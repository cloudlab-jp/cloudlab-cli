package com.cloudlabjp.cli.generator.factory;

import java.util.List;

public final class ImportFactory {

    private ImportFactory() {
    }

    public static List<String> createServiceImports(String entityName,
                                                    String basePackage,
                                                    String module) {

        return List.of(

                basePackage +
                        ".modules." +
                        module +
                        ".application.dto.Create" +
                        entityName +
                        "Request",

                basePackage +
                        ".modules." +
                        module +
                        ".application.dto." +
                        entityName +
                        "Response"

        );

    }

}