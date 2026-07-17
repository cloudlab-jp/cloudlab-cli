package {{basePackage}}.modules.{{module}}.infrastructure.controller;

import {{basePackage}}.modules.{{module}}.application.service.{{className}}Service;

public class {{className}}Controller {

    private final {{className}}Service service;

    public {{className}}Controller({{className}}Service service) {
        this.service = service;
    }

}