package com.cloudlabjp.cli.generator.imports;

import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

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

                case MANY_TO_ONE -> {

                    imports.add("jakarta.persistence.ManyToOne");
                    imports.add("jakarta.persistence.JoinColumn");
                    imports.add("jakarta.persistence.FetchType");

                }

                case ONE_TO_MANY -> {

                    imports.add("jakarta.persistence.OneToMany");
                    imports.add("jakarta.persistence.CascadeType");

                }

                case MANY_TO_MANY -> {

                    imports.add("jakarta.persistence.ManyToMany");
                    imports.add("jakarta.persistence.JoinTable");
                    imports.add("jakarta.persistence.JoinColumn");

                }

                case SIMPLE -> {
                }

            }

        }

        return imports;

    }

}