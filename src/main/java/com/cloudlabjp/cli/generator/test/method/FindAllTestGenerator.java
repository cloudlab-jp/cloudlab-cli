package com.cloudlabjp.cli.generator.test.method;

import com.cloudlabjp.cli.generator.test.body.TestMethodGenerator;
import com.cloudlabjp.cli.generator.test.body.TestMethodType;
import com.cloudlabjp.cli.generator.test.expression.RepositoryTestExpressionGenerator;
import com.cloudlabjp.cli.generator.test.template.TestMethodTemplate;

public class FindAllTestGenerator
        implements TestMethodGenerator {

    private final TestMethodTemplate template =
            new TestMethodTemplate();

    private final RepositoryTestExpressionGenerator repository =
            new RepositoryTestExpressionGenerator();

    @Override
    public boolean supports(TestMethodType type) {

        return type == TestMethodType.FIND_ALL;

    }

    @Override
    public String generate(String entity) {

        return template.build(

                "shouldFindAll",

                arrange(entity),

                act(entity),

                assertions()

        );

    }

    private String arrange(String entity) {

        return """
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
                        repository.findAll()
                );

    }

    private String act(String entity) {

        return """
                var result =
                        service.findAll();
                """;

    }

    private String assertions() {

        return """
            assertNotNull(result);

            verify(repository).findAll();

            verify(mapper).toResponse(entity);
            """;

    }

}