package com.robinfood.encuestas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SwaggerConfig {
    private static final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public Docket createRestApi() {
        log.info("createRestApi");

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                                                      .select()
                                                      .apis(RequestHandlerSelectors.basePackage("com.robinfood.encuestas.controller"))
                                                      .paths(PathSelectors.any())
                                                      .build();
    }
    
    /**
     * SwaggerUI information
     */

    @Bean
    UiConfiguration uiConfig() {
    	return UiConfigurationBuilder.builder()
                .defaultModelsExpandDepth(-1)
                .build();
    }

    private ApiInfo apiInfo() {
        log.info("apiInfo");

        return new ApiInfoBuilder().title("Documentación del API Rest Encuestas Robin food")
                                   .description("El presente documento detalla cada una de las operaciones del API robinfood-encuestas, al igual que los respectivos request y response")
                                   .contact(new Contact("Sergio Iván Mayor Pachón", null, "sergiomapa0206@gmail.com")) 
                                   .version("1.0").build();
    }
}
