package com.cloudlabjp.cli.parser;

import com.cloudlabjp.cli.model.FieldKind;
import com.cloudlabjp.cli.model.RelationshipDefinition;

public class RelationshipParser {

    public ParsedRelationship parse(
            String fieldName,
            String type
    ) {

        if (type.endsWith("#")) {

            String entityType = type.substring(
                    0,
                    type.length() - 1
            );

            return new ParsedRelationship(

                    entityType,

                    FieldKind.MANY_TO_ONE,

                    new RelationshipDefinition(

                            null,

                            fieldName + "_id"

                    )

            );

        }

        return new ParsedRelationship(

                type,

                FieldKind.SIMPLE,

                null

        );

    }

}