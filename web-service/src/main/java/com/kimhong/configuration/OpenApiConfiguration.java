package com.kimhong.configuration;

import com.kimhong.constant.ApiConstant;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi(){

        return new OpenAPI().info(new Info()
                .title("DGB Article Management API")
                .version(ApiConstant.API_VERSION)
                .description("Api documentation for client")
                .termsOfService("http://swagger.io/terms/")
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org"))
        );

    }
}
