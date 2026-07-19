package com.cloudlabjp.cli.editor.configurer;

import com.cloudlabjp.cli.editor.CompilationUnitEditor;
import com.cloudlabjp.cli.generator.factory.method.FindByRelationMethodFactory;
import com.cloudlabjp.cli.model.FieldDefinition;
import com.cloudlabjp.cli.model.FieldKind;

import java.util.List;

public class RepositoryMethodConfigurer {

    public void configure(
            CompilationUnitEditor unit,
            String entity,
            List<FieldDefinition> fields
    ) {

        for (FieldDefinition field : fields) {

            if (field.kind() == FieldKind.MANY_TO_ONE) {

                unit.clazz()

                        .repository()

                        .addMethod(

                                FindByRelationMethodFactory.build(
                                        entity,
                                        field
                                )

                        );

            }

        }

    }

}