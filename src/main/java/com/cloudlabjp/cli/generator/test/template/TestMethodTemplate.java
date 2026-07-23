package com.cloudlabjp.cli.generator.test.template;

public class TestMethodTemplate {

    public String build(
            String methodName,
            String arrange,
            String act,
            String assertions
    ) {

        return """
                @Test
                void %s() {

                    // Arrange

                %s

                    // Act

                %s

                    // Assert

                %s

                }
                """
                .formatted(
                        methodName,
                        indent(arrange),
                        indent(act),
                        indent(assertions)
                );

    }

    private String indent(String text) {

        return text
                .indent(4)
                .stripTrailing();

    }

}