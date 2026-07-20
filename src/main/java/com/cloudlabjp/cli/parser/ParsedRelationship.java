package com.cloudlabjp.cli.parser;

import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.model.RelationshipDefinition;

public record ParsedRelationship(

        String type,

        FieldKind kind,

        RelationshipDefinition relationship

) {
}