package com.cloudlabjp.cli.service;

import com.cloudlabjp.cli.util.ConsolePrinter;

public class EntityGeneratorService {

    public void createEntity(String moduleName, String entityName) {

        ConsolePrinter.info("");
        ConsolePrinter.info("Creating entity: " + entityName);
        ConsolePrinter.info("Module: " + moduleName);
        ConsolePrinter.info("");

        ConsolePrinter.success("Done.");

    }

}