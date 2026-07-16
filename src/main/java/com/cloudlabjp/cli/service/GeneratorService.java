package com.cloudlabjp.cli.service;

import com.cloudlabjp.cli.util.ConsolePrinter;

public class GeneratorService {

    public void createModule(String moduleName) {

        ConsolePrinter.info("");
        ConsolePrinter.info("Creating module " + moduleName + "...");
        ConsolePrinter.info("");

        ConsolePrinter.success("application");
        ConsolePrinter.success("domain");
        ConsolePrinter.success("infrastructure");

        ConsolePrinter.info("");
        ConsolePrinter.success("Done.");

    }

}