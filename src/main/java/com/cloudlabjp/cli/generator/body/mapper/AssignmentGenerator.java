package com.cloudlabjp.cli.generator.body.mapper;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

public interface AssignmentGenerator {

    boolean supports(FieldKind kind);

    String entity(FieldDefinition field);

    String update(FieldDefinition field);

    String response(FieldDefinition field);

}