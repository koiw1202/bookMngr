package com.bookMngr.common.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        String[] paths = {"/v1/**"};
        Info info = new Info().title("도서 관리 시스템").version("v1.0") ;

        SecurityScheme accessToken = setSecuritySchema("x-access-token");
        SecurityScheme xRefToken = setSecuritySchema("x-ref-token");

        SecurityRequirement addSecurityItem = new SecurityRequirement();
        addSecurityItem
                .addList("accessToken")
                .addList("xRefToken")
        ;

        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes("accessToken" , accessToken)
                                .addSecuritySchemes("xRefToken" , xRefToken)
                )
                .addSecurityItem(addSecurityItem)
                .info(info) ;

    }

    private SecurityScheme setSecuritySchema(String name){
        return new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER)
                .name(name);
    }

}