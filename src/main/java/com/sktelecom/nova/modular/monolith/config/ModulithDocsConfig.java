package com.sktelecom.nova.modular.monolith.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

//@Configuration
public class ModulithDocsConfig {

    //@Bean
    ApplicationRunner generateModulithDocs() {
        return args -> {
            // 애플리케이션 모듈 정보 생성
            ApplicationModules modules = ApplicationModules.of("com.sktelecom.nova.modular.monolith");

            // Documenter 인스턴스 생성 후 문서 작성
            new Documenter(modules).writeDocumentation();
        };
    }
}