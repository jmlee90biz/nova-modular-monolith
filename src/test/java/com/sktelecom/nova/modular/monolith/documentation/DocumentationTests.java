package com.sktelecom.nova.modular.monolith.documentation;

import com.sktelecom.nova.modular.monolith.NovaModularMonolithApplication;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 02 Jun, 2024
 */

public class DocumentationTests {
    ApplicationModules modules = ApplicationModules.of(NovaModularMonolithApplication.class);

    @Test
    void writeDocumentationSnippets(){
        new Documenter(modules)
                .writeDocumentation()
                .writeAggregatingDocument()
                .writeModulesAsPlantUml(Documenter.DiagramOptions.defaults()
                        .withStyle(Documenter.DiagramOptions.DiagramStyle.C4))

                .writeIndividualModulesAsPlantUml(Documenter.DiagramOptions.defaults()
                        .withStyle(Documenter.DiagramOptions.DiagramStyle.C4))

                .writeModuleCanvases();

        Documenter.DiagramOptions.defaults()
                .withStyle(Documenter.DiagramOptions.DiagramStyle.C4);
    }
}
