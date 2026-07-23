package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.List;

public class AssignmentGeneratorRegistry {

    private final List<AssignmentGenerator> generators =
            List.of(
                    new SimpleAssignmentGenerator(),
                    new RelationAssignmentGenerator()
            );

    private AssignmentGenerator generator(FieldDefinition field) {

        return generators.stream()
                .filter(g -> g.supports(field.kind()))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Unsupported field kind: "
                                        + field.kind()
                        ));

    }

    public String entityAssignment(FieldDefinition field) {

        return generator(field).entity(field);

    }

    public String updateAssignment(FieldDefinition field) {

        return generator(field).update(field);

    }

    public String responseAssignment(FieldDefinition field) {

        return generator(field).response(field);

    }

}