package com.cloudlabjp.cli.generator.test.method;

import com.cloudlabjp.cli.generator.test.body.TestMethodGenerator;
import com.cloudlabjp.cli.generator.test.body.TestMethodType;
import com.cloudlabjp.cli.generator.test.expression.RepositoryTestExpressionGenerator;
import com.cloudlabjp.cli.generator.test.template.TestMethodTemplate;

public class CreateTestGenerator
        implements TestMethodGenerator {

    private final TestMethodTemplate template =
            new TestMethodTemplate();

    private final RepositoryTestExpressionGenerator repositoryExpressions =
            new RepositoryTestExpressionGenerator();

    @Override
    public boolean supports(TestMethodType type) {

        return type == TestMethodType.CREATE;

    }

    @Override
    public String generate(String entity) {

        return template.build(

                "shouldCreate",

                arrange(entity),

                act(entity),

                assertions()

        );

    }

    private String arrange(String entity) {

        return """
                Create%sRequest request =
                        new Create%sRequest();

                %s entity =
                        new %s();

                %sResponse response =
                        new %sResponse();

                when(mapper.toEntity(request))
                        .thenReturn(entity);

                when(repository.save(entity))
                        .thenReturn(entity);

                when(mapper.toResponse(entity))
                        .thenReturn(response);
                """
                .formatted(
                        entity,
                        entity,
                        entity,
                        entity,
                        entity,
                        entity
                );

    }

    private String act(String entity) {

        return """
                %sResponse result =
                        service.create(request);
                """
                .formatted(entity);

    }

    private String assertions() {

        return """
            assertNotNull(result);

            verify(mapper).toEntity(request);

            %s

            verify(mapper).toResponse(entity);
            """
                .formatted(
                        repositoryExpressions.verifySave()
                );

    }

}