package com.cloudlabjp.cli.generator.test.method;

import com.cloudlabjp.cli.generator.test.body.TestMethodGenerator;
import com.cloudlabjp.cli.generator.test.body.TestMethodType;
import com.cloudlabjp.cli.generator.test.template.TestMethodTemplate;

public class DeleteTestGenerator
        implements TestMethodGenerator {

    private final TestMethodTemplate template =
            new TestMethodTemplate();

    @Override
    public boolean supports(TestMethodType type) {

        return type == TestMethodType.DELETE;

    }

    @Override
    public String generate(String entity) {

        return template.build(

                "shouldDelete",

                "Long id = 1L;",

                """
                service.delete(id);
                """,

                """
                verify(repository).deleteById(id);
                """

        );

    }

}