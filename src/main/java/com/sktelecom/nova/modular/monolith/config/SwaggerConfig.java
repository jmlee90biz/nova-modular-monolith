package com.sktelecom.nova.modular.monolith.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NOVA Modular Monolith")
                        .version("1.0.0")
                        .description("Modular Monolith 기반 서비스 API 문서")
                )
                .tags(List.of(
                        new Tag().name("product-catalog").description("상품 카탈로그"),
                        new Tag().name("product-pricing").description("상품 가격 관리"),
                        new Tag().name("partner-management").description("파트너 관리"),
                        new Tag().name("partner-settlement").description("파트너 정산"),
                        new Tag().name("customer-profile").description("고객 프로필 관리"),
                        new Tag().name("customer-subscription").description("고객 구독 관리")

                ))
                .extensions(Map.of(
                        "x-tagGroups", List.of(
                                Map.of("name", "Customer Management", "tags", List.of("customer-profile", "customer-subscription")),
                                Map.of("name", "Product Management", "tags", List.of("product-catalog", "product-pricing"))
                        )
                ));
    }
}