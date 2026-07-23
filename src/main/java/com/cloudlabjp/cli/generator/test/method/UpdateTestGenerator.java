package com.cloudlabjp.cli.generator.test.method;

import com.cloudlabjp.cli.generator.test.body.TestMethodGenerator;
import com.cloudlabjp.cli.generator.test.body.TestMethodType;
import com.cloudlabjp.cli.generator.test.expression.RepositoryTestExpressionGenerator;
import com.cloudlabjp.cli.generator.test.template.TestMethodTemplate;

public class UpdateTestGenerator
        implements TestMethodGenerator {

    private final TestMethodTemplate template =
            new TestMethodTemplate();

    private final RepositoryTestExpressionGenerator repositoryExpressions =
            new RepositoryTestExpressionGenerator();

    @Override
    public boolean supports(TestMethodType type) {

        return type == TestMethodType.UPDATE;

    }

    @Override
    public String generate(String entity) {

        return template.build(

                "shouldUpdate",

                arrange(entity),

                act(entity),

                assertions()

        );

    }

    private String arrange(String entity) {

        return """
                Long id = 1L;

                Update%sRequest request =
                        new Update%sRequest();

                %s entity =
                        new %s();

                %sResponse response =
                        new %sResponse();

                %s

                %s

                when(mapper.toResponse(entity))
                        .thenReturn(response);
                """
                .formatted(
                        entity,
                        entity,
                        entity,
                        entity,
                        entity,
                        entity,
                        repositoryExpressions.findById(),
                        repositoryExpressions.save()
                );

    }

    private String act(String entity) {

        return """
                %sResponse result =
                        service.update(id, request);
                """
                .formatted(entity);

    }

    private String assertions() {

        return """
            assertNotNull(result);

            %s

            %s

            verify(mapper).update(entity, request);

            verify(mapper).toResponse(entity);
            """
                .formatted(
                        repositoryExpressions.verifyFindById(),
                        repositoryExpressions.verifySave()
                );

    }

}