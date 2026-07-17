package com.cloudlabjp.cli.command;

import com.cloudlabjp.cli.editor.ClassEditor;
import com.cloudlabjp.cli.editor.JavaSourceEditor;
import com.cloudlabjp.cli.model.MethodDefinition;
import com.cloudlabjp.cli.model.ParameterDefinition;
import com.github.javaparser.ast.CompilationUnit;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.nio.file.Path;
import java.util.List;

@Command(
        name = "ast",
        description = "Inspect a Java source file."
)
public class AstCommand implements Runnable {

    @Option(
            names = "-f",
            required = true,
            description = "Java file"
    )
    private Path file;

    @Override
    public void run() {

        JavaSourceEditor editor =
                new JavaSourceEditor(file);

        editor.classEditor()
                .addMethod(

                        new MethodDefinition(

                                "create",

                                "String",

                                List.of(
                                        new ParameterDefinition(
                                                "String",
                                                "name"
                                        )
                                ),

                                """
                                return "Hello " + name;
                                """

                        )

                );

        editor.save();

    }



}