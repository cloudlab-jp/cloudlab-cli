package com.cloudlabjp.cli.generator;

import com.cloudlabjp.cli.generator.model.GeneratedFile;
import com.cloudlabjp.cli.util.ConsolePrinter;
import com.cloudlabjp.cli.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class GeneratedFileWriter {

    public void write(
            Path modulePath,
            List<GeneratedFile> files
    ) throws IOException {

        for (GeneratedFile file : files) {

            Path output =
                    modulePath.resolve(file.relativePath());

            FileSystemUtils.createDirectory(
                    output.getParent()
            );

            FileGenerator.createFile(
                    output,
                    file.content()
            );

            ConsolePrinter.success(
                    file.relativePath()
            );

        }

    }

}