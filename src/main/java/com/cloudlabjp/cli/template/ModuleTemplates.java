package com.cloudlabjp.cli.template;

import java.util.List;

public final class ModuleTemplates {

    private ModuleTemplates() {
    }

    public static ModuleTemplate springModule() {

        return new ModuleTemplate(
                "spring",
                List.of(

                        "application",
                        "application/dto",
                        "application/service",
                        "application/mapper",

                        "domain",
                        "domain/model",
                        "domain/repository",
                        "domain/event",

                        "infrastructure",
                        "infrastructure/controller",
                        "infrastructure/persistence",
                        "infrastructure/configuration"
                ),
                List.of(
                        "application/dto/.gitkeep",
                        "application/service/.gitkeep",
                        "application/mapper/.gitkeep",

                        "domain/model/.gitkeep",
                        "domain/repository/.gitkeep",
                        "domain/event/.gitkeep",

                        "infrastructure/controller/.gitkeep",
                        "infrastructure/persistence/.gitkeep",
                        "infrastructure/configuration/.gitkeep"
                )
        );

    }

}