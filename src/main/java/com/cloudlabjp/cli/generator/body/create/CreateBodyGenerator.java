package com.cloudlabjp.cli.generator.body.create;

public class CreateBodyGenerator {

    public String generate(String entityName) {

        return """
                %s entity = mapper.toEntity(request);

                entity = repository.save(entity);

                return mapper.toResponse(entity);
                """.formatted(entityName);

    }

}