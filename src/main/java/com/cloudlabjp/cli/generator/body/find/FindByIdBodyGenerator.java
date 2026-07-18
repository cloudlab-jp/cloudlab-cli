package com.cloudlabjp.cli.generator.body.find;

public class FindByIdBodyGenerator {

    public String generate(String entityName) {

        return """
                %s entity = repository.findById(id)
                        .orElseThrow();

                return mapper.toResponse(entity);
                """.formatted(entityName);

    }

}