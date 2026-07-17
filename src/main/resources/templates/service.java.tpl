package {{basePackage}}.modules.{{module}}.application.service;

import {{basePackage}}.modules.{{module}}.domain.repository.{{className}}Repository;

public class {{className}}Service {

    private final {{className}}Repository repository;

    public {{className}}Service({{className}}Repository repository) {
        this.repository = repository;
    }

}