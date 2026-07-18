package com.cloudlabjp.cli.generator.factory.annotation;

import java.util.List;

public final class EntityAnnotationFactory {

    private EntityAnnotationFactory() {
    }

    public static List<String> build() {

        return List.of(
                "jakarta.persistence.Entity",
                "jakarta.persistence.Table",
                "jakarta.persistence.Id",
                "jakarta.persistence.GeneratedValue",
                "jakarta.persistence.GenerationType"
        );

    }

}