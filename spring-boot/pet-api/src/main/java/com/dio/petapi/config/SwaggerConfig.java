package com.dio.petapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dio.petapi.controller"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.POST, responseForPost())
                .globalResponses(HttpMethod.GET, responseForGet())
                .globalResponses(HttpMethod.PUT, responseForPut())
                .globalResponses(HttpMethod.DELETE, responseForDelete())
                .apiInfo(apiInfo());
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PetAPI")
                .description("API para gerenciamento de animais domésticos e seus donos.")
                .version("1.0.0")
                .build();
    }

    private List<Response> responseForPost() {
        return new ArrayList<>() {{
            add(new ResponseBuilder().code("500").description("An exception occurred").build());
            add(new ResponseBuilder().code("409").description("An information conflict occurred").build());
            add(new ResponseBuilder().code("400").description("An information validation error occurred").build());
            add(new ResponseBuilder().code("201").description("Entity created").build());
        }};
    }

    private List<Response> responseForGet() {
        return new ArrayList<>() {{
            add(new ResponseBuilder().code("500").description("An exception occurred").build());
            add(new ResponseBuilder().code("404").description("Entity not found").build());
        }};
    }

    private List<Response> responseForPut() {
        return new ArrayList<>() {{
            add(new ResponseBuilder().code("500").description("An exception occurred").build());
            add(new ResponseBuilder().code("409").description("An information conflict occurred").build());
            add(new ResponseBuilder().code("400").description("An information validation error occurred").build());
            add(new ResponseBuilder().code("200").description("Entity updated").build());
        }};
    }

    private List<Response> responseForDelete() {
        return new ArrayList<>() {{
            add(new ResponseBuilder().code("500").description("An exception occurred").build());
            add(new ResponseBuilder().code("404").description("Entity not found").build());
            add(new ResponseBuilder().code("204").description("Entity deleted").build());
        }};
    }

}
