package com.cloudlabjp.cli.generator.test.body;

public class ServiceTestBodyGenerator {

    private final TestGeneratorRegistry registry =
            new TestGeneratorRegistry();

    public String generate(String entity) {

        StringBuilder builder =
                new StringBuilder();

        builder.append(
                registry.generate(
                        TestMethodType.CREATE,
                        entity
                )
        );

        builder.append(System.lineSeparator());

        builder.append(
                registry.generate(
                        TestMethodType.UPDATE,
                        entity
                )
        );

        builder.append(System.lineSeparator());

        builder.append(
                registry.generate(
                        TestMethodType.DELETE,
                        entity
                )
        );

        builder.append(System.lineSeparator());

        builder.append(
                registry.generate(
                        TestMethodType.FIND_BY_ID,
                        entity
                )
        );

        builder.append(System.lineSeparator());

        builder.append(
                registry.generate(
                        TestMethodType.FIND_ALL,
                        entity
                )
        );

        return builder.toString();

    }

}