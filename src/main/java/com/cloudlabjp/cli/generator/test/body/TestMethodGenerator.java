package com.cloudlabjp.cli.generator.test.body;

public interface TestMethodGenerator {

    boolean supports(TestMethodType type);

    String generate(String entity);

}