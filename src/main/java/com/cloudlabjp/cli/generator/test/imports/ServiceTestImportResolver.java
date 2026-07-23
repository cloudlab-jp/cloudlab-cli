package com.cloudlabjp.cli.generator.test.imports;

import com.cloudlabjp.cli.project.ProjectInfo;

public class ServiceTestImportResolver {

    public String resolve(
            ProjectInfo project,
            String module,
            String entity
    ) {

        String base =
                project.basePackage()
                        + ".modules."
                        + module;

        return """
            import org.junit.jupiter.api.Test;
            import org.junit.jupiter.api.extension.ExtendWith;

            import org.mockito.InjectMocks;
            import org.mockito.Mock;
            import org.mockito.junit.jupiter.MockitoExtension;

            import static org.junit.jupiter.api.Assertions.*;
            import static org.mockito.Mockito.*;

            import %s.domain.repository.%sRepository;
            import %s.application.mapper.%sMapper;

            import %s.application.dto.Create%sRequest;
            import %s.application.dto.Update%sRequest;
            import %s.application.dto.%sResponse;

            import %s.domain.model.%s;
            """
                .formatted(
                        base,
                        entity,

                        base,
                        entity,

                        base,
                        entity,

                        base,
                        entity,

                        base,
                        entity,

                        base,
                        entity
                );

    }

}