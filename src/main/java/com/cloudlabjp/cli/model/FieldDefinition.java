package com.cloudlabjp.cli.model;

import java.util.List;

public record FieldDefinition(

        String name,

        String type,

        FieldKind kind,

        boolean required,

        RelationshipDefinition relationship,

        List<String> enumValues

) {
}