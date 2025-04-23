package com.sktelecom.nova.modular.monolith;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.core.DependencyType;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ContextConfiguration;


@ApplicationModuleTest
class ModularArchitectureTest {

    @Test
    void verifyModularStructure() {
        ApplicationModules.of(NovaModularMonolithApplication.class).verify();
    }
}









//@SpringBootTest
@ApplicationModuleTest
class NovaModularMonolithApplicationTests {
    @Test
    void contextLoads() {
        ApplicationModules modules = ApplicationModules.of(NovaModularMonolithApplication.class);

        modules.forEach(System.out::println);

        modules.verify();
    }

}
