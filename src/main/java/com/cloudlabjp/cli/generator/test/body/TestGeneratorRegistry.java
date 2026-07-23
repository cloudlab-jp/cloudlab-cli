package com.cloudlabjp.cli.generator.test.body;

import com.cloudlabjp.cli.generator.test.method.CreateTestGenerator;
import com.cloudlabjp.cli.generator.test.method.DeleteTestGenerator;
import com.cloudlabjp.cli.generator.test.method.FindAllTestGenerator;
import com.cloudlabjp.cli.generator.test.method.FindByIdTestGenerator;
import com.cloudlabjp.cli.generator.test.method.UpdateTestGenerator;

import java.util.List;

public class TestGeneratorRegistry {

    private final List<TestMethodGenerator> generators =
            List.of(
                    new CreateTestGenerator(),
                    new UpdateTestGenerator(),
                    new DeleteTestGenerator(),
                    new FindByIdTestGenerator(),
                    new FindAllTestGenerator()
            );

    private TestMethodGenerator generator(TestMethodType type) {

        return generators.stream()
                .filter(g -> g.supports(type))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Unsupported test type: " + type
                        )
                );

    }

    public String generate(
            TestMethodType type,
            String entity
    ) {

        return generator(type).generate(entity);

    }

}