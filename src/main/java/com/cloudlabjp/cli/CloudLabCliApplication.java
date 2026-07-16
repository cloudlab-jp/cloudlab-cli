package com.cloudlabjp.cli;

import com.cloudlabjp.cli.command.RootCommand;
import com.cloudlabjp.cli.project.ProjectDetector;
import com.cloudlabjp.cli.project.ProjectInfo;
import picocli.CommandLine;

import java.nio.file.Path;

public class CloudLabCliApplication {

    public static void main(String[] args) {

        ProjectDetector detector = new ProjectDetector();

        ProjectInfo info = detector.detect(
                Path.of("../novacommerce/backend")
        );

        System.out.println(info.projectRoot());
        System.out.println(info.sourceRoot());
        System.out.println(info.basePackage());

    }

}