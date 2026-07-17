package com.cloudlabjp.cli.generator.builder;

public class LombokEntityBuilder {

    public String buildAnnotations() {

        return """
                @Getter
                @Setter
                @Builder
                @NoArgsConstructor
                @AllArgsConstructor
                """;

    }

    public String buildImports() {

        return """
                import lombok.AllArgsConstructor;
                import lombok.Builder;
                import lombok.Getter;
                import lombok.NoArgsConstructor;
                import lombok.Setter;
                """;

    }

}