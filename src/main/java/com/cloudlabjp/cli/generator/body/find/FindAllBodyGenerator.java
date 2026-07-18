package com.cloudlabjp.cli.generator.body.find;

public class FindAllBodyGenerator {

    public String generate() {

        return """
                return repository.findAll()

                        .stream()

                        .map(mapper::toResponse)

                        .toList();
                """;

    }

}