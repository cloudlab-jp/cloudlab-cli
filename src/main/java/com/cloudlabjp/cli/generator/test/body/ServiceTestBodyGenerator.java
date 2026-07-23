package com.cloudlabjp.cli.generator.test.body;

public class ServiceTestBodyGenerator {

    public String generate() {

        return """
                @Test
                void shouldCreate() {

                }

                @Test
                void shouldUpdate() {

                }

                @Test
                void shouldDelete() {

                }

                @Test
                void shouldFindById() {

                }

                @Test
                void shouldFindAll() {

                }
                """;

    }

}