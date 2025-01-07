package com.RestaurantRegister.Restaurant.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger{

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.domain}")
    private String exampleDomain;

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(applicationName)
                        .description("Restaurant Portal API")
                        .version("v1")
                        .license(new License().name("Apache 2.0").url("https://opensource.org/licenses/Apache-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Restaurant API Documentation")
                        .url("https://example.com/api-docs"));
    }
}
