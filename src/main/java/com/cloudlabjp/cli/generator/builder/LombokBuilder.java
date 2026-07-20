package com.cloudlabjp.cli.generator.builder;

public class LombokBuilder {

    public String buildEntityImports() {

        return """
                import lombok.AllArgsConstructor;
                import lombok.Builder;
                import lombok.Getter;
                import lombok.NoArgsConstructor;
                import lombok.Setter;""";

    }

    public String buildEntityAnnotations() {

        return """
                @Getter
                @Setter
                @Builder
                @NoArgsConstructor
                @AllArgsConstructor""";

    }

    public String buildServiceImports() {

        return """
                import lombok.RequiredArgsConstructor;""";

    }

    public String buildServiceAnnotations() {

        return """
                @RequiredArgsConstructor""";

    }

    public String buildDtoImports() {

        return """
            import lombok.Getter;
            import lombok.NoArgsConstructor;
            import lombok.Setter;""";

    }

    public String buildDtoAnnotations() {

        return """
            @Getter
            @Setter
            @NoArgsConstructor""";

    }

}