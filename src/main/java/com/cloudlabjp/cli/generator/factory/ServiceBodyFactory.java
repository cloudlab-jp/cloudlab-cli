package com.cloudlabjp.cli.generator.factory;

public final class ServiceBodyFactory {

    private ServiceBodyFactory() {
    }

    public static String createBody(String entityName) {

        return """
                %s entity = %s.builder()
                        .build();

                entity = repository.save(entity);

                return null;
                """.formatted(
                entityName,
                entityName
        );

    }

    public static String updateBody() {

        return """
                return null;
                """;

    }

    public static String deleteBody() {

        return """
                repository.deleteById(id);
                """;

    }

    public static String findByIdBody() {

        return """
                return null;
                """;

    }

    public static String findAllBody() {

        return """
                return List.of();
                """;

    }

}