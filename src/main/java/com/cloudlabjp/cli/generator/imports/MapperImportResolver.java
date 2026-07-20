package com.cloudlabjp.cli.generator.imports;

public class MapperImportResolver {

    public String resolve(
            String basePackage,
            String module,
            String entityName
    ) {

        String base = basePackage
                + ".modules."
                + module;

        return """
                import %s.application.dto.Create%sRequest;
                import %s.application.dto.Update%sRequest;
                import %s.application.dto.%sResponse;
                import %s.domain.model.%s;
                """.formatted(
                base, entityName,
                base, entityName,
                base, entityName,
                base, entityName
        );

    }

}