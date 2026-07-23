package com.cloudlabjp.cli.generator.test.imports;

public class ServiceTestImportResolver {

    public String resolve(
            String basePackage,
            String module,
            String entity
    ) {

        String base =
                basePackage + ".modules." + module;

        return """
                import org.junit.jupiter.api.Test;
                import org.junit.jupiter.api.extension.ExtendWith;

                import org.mockito.InjectMocks;
                import org.mockito.Mock;
                import org.mockito.junit.jupiter.MockitoExtension;

                import %s.domain.repository.%sRepository;
                import %s.application.mapper.%sMapper;
                """
                .formatted(
                        base,
                        entity,
                        base,
                        entity
                );

    }

}