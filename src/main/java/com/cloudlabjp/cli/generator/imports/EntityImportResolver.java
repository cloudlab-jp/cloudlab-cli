package com.cloudlabjp.cli.generator.imports;

import java.util.LinkedHashSet;
import java.util.Set;

public class EntityImportResolver {

    public Set<String> resolve() {

        Set<String> imports = new LinkedHashSet<>();

        imports.add("jakarta.persistence.Entity");
        imports.add("jakarta.persistence.Table");
        imports.add("jakarta.persistence.Id");
        imports.add("jakarta.persistence.GeneratedValue");
        imports.add("jakarta.persistence.GenerationType");

        imports.add("lombok.Getter");
        imports.add("lombok.Setter");
        imports.add("lombok.Builder");
        imports.add("lombok.NoArgsConstructor");
        imports.add("lombok.AllArgsConstructor");

        return imports;

    }

}