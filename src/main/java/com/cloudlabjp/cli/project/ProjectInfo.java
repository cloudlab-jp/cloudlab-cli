package com.cloudlabjp.cli.project;

import java.nio.file.Path;

public record ProjectInfo(

        Path projectRoot,
        Path sourceRoot,
        String basePackage

) {
}