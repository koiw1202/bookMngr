package com.example.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        String[] paths = {"/v1/**"};
        Info info = new Info().title("타이틀").version("v1.0") ;

        return new OpenAPI().components(new Components()).info(info) ;

    }
}