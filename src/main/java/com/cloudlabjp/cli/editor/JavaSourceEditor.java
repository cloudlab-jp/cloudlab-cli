package com.cloudlabjp.cli.editor;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaSourceEditor {

    private final Path file;

    private final CompilationUnit unit;

    public JavaSourceEditor(Path file) {

        this.file = file;

        try {

            this.unit = StaticJavaParser.parse(file);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public CompilationUnitEditor editor() {

        return new CompilationUnitEditor(unit);

    }

    public void save() {

        try {

            Files.writeString(
                    file,
                    unit.toString()
            );

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public String getClassName() {

        return editor()

                .clazz()

                .getClassName();

    }

    public Path getFile() {

        return file;

    }

}