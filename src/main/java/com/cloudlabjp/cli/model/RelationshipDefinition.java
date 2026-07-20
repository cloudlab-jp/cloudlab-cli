package com.cloudlabjp.cli.model;

public record RelationshipDefinition(

        String mappedBy,

        String joinColumn

) {
}