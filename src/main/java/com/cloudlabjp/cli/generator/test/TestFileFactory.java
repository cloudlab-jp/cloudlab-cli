package com.cloudlabjp.cli.generator.test;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.project.ProjectInfo;

import java.util.List;

public interface TestFileFactory {

    List<GeneratedFile> create(

            ProjectInfo project,

            String module,

            String entity

    );

}