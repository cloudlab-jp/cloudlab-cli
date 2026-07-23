package com.cloudlabjp.cli.generator.test.method;

import com.cloudlabjp.cli.generator.test.body.TestMethodGenerator;
import com.cloudlabjp.cli.generator.test.body.TestMethodType;
import com.cloudlabjp.cli.generator.test.expression.RepositoryTestExpressionGenerator;
import com.cloudlabjp.cli.generator.test.template.TestMethodTemplate;

public class FindByIdTestGenerator
        implements TestMethodGenerator {

    private final TestMethodTemplate template =
            new TestMethodTemplate();

    private final RepositoryTestExpressionGenerator repository =
            new RepositoryTestExpressionGenerator();

    @Override
    public boolean supports(TestMethodType type) {

        return type == TestMethodType.FIND_BY_ID;

    }

    @Override
    public String generate(String entity) {

        return template.build(

                "shouldFindById",

                arrange(entity),

                act(entity),

                assertions()

        );

    }

    private String arrange(String entity) {

        return """
                Long id = 1L;

                %s entity =
                        new %s();

                %sResponse response =
                        new %sResponse();

                %s

                when(mapper.toResponse(entity))
                        .thenReturn(response);
                """
                .formatted(
                        entity,
                        entity,
                        entity,
                        entity,
                        repository.findById()
                );

    }

    private String act(String entity) {

        return """
                %sResponse result =
                        service.findById(id);
                """
                .formatted(entity);

    }

    private String assertions() {

        return """
            assertNotNull(result);

            %s

            verify(mapper).toResponse(entity);
            """
                .formatted(
                        repository.verifyFindById()
                );

    }

}