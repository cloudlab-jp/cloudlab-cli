package com.cloudlabjp.cli.template;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ResourceTemplateEngine {

    public String render(String template,
                         Map<String, String> variables) {

        try (InputStream input =
                     getClass().getClassLoader()
                             .getResourceAsStream("templates/" + template)) {

            if (input == null) {
                throw new IllegalArgumentException(
                        "Template not found: " + template
                );
            }

            String content = new String(
                    input.readAllBytes(),
                    StandardCharsets.UTF_8
            );

            for (Map.Entry<String, String> entry : variables.entrySet()) {

                content = content.replace(
                        "{{" + entry.getKey() + "}}",
                        entry.getValue()
                );

            }

            return content;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}