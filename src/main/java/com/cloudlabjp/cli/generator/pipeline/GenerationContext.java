package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.nio.file.Path;
import java.util.List;

public record GenerationContext(

        Path file,

        String entityName,

        List<FieldDefinition> fields

) {
}