package com.cloudlabjp.cli.template;

import java.util.List;

public record ModuleTemplate(

        String name,

        List<String> directories,

        List<String> files

) {
}