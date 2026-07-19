package com.cloudlabjp.cli.editor.configurer.imports;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.model.FieldKind;

public class RelationshipImportsConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            FieldKind kind
    ) {

        switch (kind) {

            case MANY_TO_ONE -> configureManyToOne(unit);

            case ONE_TO_MANY -> configureOneToMany(unit);

            case MANY_TO_MANY -> configureManyToMany(unit);

            default -> {
            }

        }

    }

    private void configureManyToOne(
            CompilationUnitEditor unit
    ) {

        unit.imports()

                .add("jakarta.persistence.ManyToOne")

                .add("jakarta.persistence.FetchType")

                .add("jakarta.persistence.JoinColumn");

    }

    private void configureOneToMany(
            CompilationUnitEditor unit
    ) {

        unit.imports()

                .add("jakarta.persistence.OneToMany")

                .add("jakarta.persistence.CascadeType")

                .add("java.util.List")

                .add("java.util.ArrayList");

    }

    private void configureOneToOne(
            CompilationUnitEditor unit
    ) {

    }

    private void configureManyToMany(
            CompilationUnitEditor unit
    ) {

    }

}