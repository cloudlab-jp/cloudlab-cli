package com.cloudlabjp.cli.generator.body.update;

public class UpdateBodyGenerator {

    public String generate(String entityName) {

        return """
                %s entity = repository.findById(id)
                        .orElseThrow();

                mapper.update(entity, request);

                entity = repository.save(entity);

                return mapper.toResponse(entity);
                """.formatted(entityName);

    }

}