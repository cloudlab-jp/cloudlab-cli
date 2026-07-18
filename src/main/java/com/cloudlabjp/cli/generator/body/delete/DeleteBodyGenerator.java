package com.cloudlabjp.cli.generator.body.delete;

public class DeleteBodyGenerator {

    public String generate() {

        return """
                repository.deleteById(id);
                """;

    }

}