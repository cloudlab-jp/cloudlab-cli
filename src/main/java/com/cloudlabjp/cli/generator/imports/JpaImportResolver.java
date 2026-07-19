package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JpaImportResolver {

    public Set<String> resolve(List<FieldDefinition> fields) {

        Set<String> imports = new LinkedHashSet<>();

        if (fields == null) {
            return imports;
        }

        for (FieldDefinition field : fields) {

            switch (field.kind()) {

                case MANY_TO_ONE -> resolveManyToOne(imports);

                case ONE_TO_MANY -> resolveOneToMany(imports);

                case MANY_TO_MANY -> resolveManyToMany(imports);



                case SIMPLE -> {
                }

            }

        }

        return imports;

    }

    private void resolveManyToOne(Set<String> imports) {

        imports.add("jakarta.persistence.ManyToOne");
        imports.add("jakarta.persistence.JoinColumn");
        imports.add("jakarta.persistence.FetchType");

    }

    private void resolveOneToMany(Set<String> imports) {

        imports.add("jakarta.persistence.OneToMany");
        imports.add("jakarta.persistence.CascadeType");

    }

    private void resolveManyToMany(Set<String> imports) {

        imports.add("jakarta.persistence.ManyToMany");
        imports.add("jakarta.persistence.JoinTable");
        imports.add("jakarta.persistence.JoinColumn");

    }

    private void resolveOneToOne(Set<String> imports) {

        imports.add("jakarta.persistence.OneToOne");
        imports.add("jakarta.persistence.JoinColumn");

    }

}