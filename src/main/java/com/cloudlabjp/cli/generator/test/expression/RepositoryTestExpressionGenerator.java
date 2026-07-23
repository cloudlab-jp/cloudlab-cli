package com.cloudlabjp.cli.generator.test.expression;

public class RepositoryTestExpressionGenerator {

    public String findById() {

        return """
                when(repository.findById(id))
                        .thenReturn(java.util.Optional.of(entity));
                """;

    }

    public String save() {

        return """
                when(repository.save(entity))
                        .thenReturn(entity);
                """;

    }

    public String verifySave() {

        return """
                verify(repository).save(entity);
                """;

    }

    public String verifyFindById() {

        return """
                verify(repository).findById(id);
                """;

    }

    public String verifyDelete() {

        return """
                verify(repository).deleteById(id);
                """;

    }

    public String findAll() {

        return """
                when(repository.findAll())
                        .thenReturn(java.util.List.of(entity));
                """;

    }

}