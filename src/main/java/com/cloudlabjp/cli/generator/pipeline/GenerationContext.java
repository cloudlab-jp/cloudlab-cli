package com.cloudlabjp.cli.generator.pipeline;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.nio.file.Path;
import java.util.List;

public record GenerationContext(

        ProjectInfo project,

        String module,

        Path file,

        String entityName,

        List<FieldDefinition> fields

) {}