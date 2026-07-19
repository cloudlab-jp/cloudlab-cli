package com.cloudlabjp.cli.model;

public record FieldDefinition(

        String name,

        String type,

        boolean required

) {
}