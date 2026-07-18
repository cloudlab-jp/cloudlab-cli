package com.cloudlabjp.cli.editor;

import com.cloudlabjp.cli.generator.factory.method.CreateMethodFactory;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassEditorTest {

    @Test
    void shouldAddMethod() {

        CompilationUnit unit = StaticJavaParser.parse("""

package com.cloudlabjp.demo;

public class Demo {

}

""");

        var clazz = unit
                .getClassByName("Demo")
                .orElseThrow();

        var editor = new ClassEditor(clazz);

        editor.addMethod(
                CreateMethodFactory.build("Ventas")
        );

        assertTrue(
                editor.hasMethod("create")
        );

    }

}