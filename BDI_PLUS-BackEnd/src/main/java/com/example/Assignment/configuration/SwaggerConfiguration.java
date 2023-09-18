package com.example.Assignment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInformation())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    public ApiInfo getInformation(){

        return new ApiInfo("Assignment Application : BackEnd",
                "This is Java/Spring boot bases BackEnd Application.",
                "1.0.1",
                "N/A",new Contact("Sarvesh ",
                "https://linktr.ee/sanvusarvesh?utm_source=linktree_profile_share&ltsid=94d91cc4-ab65-46e5-a845-e00a99b6cdd7",
                "sarveshkr1308@gmail.com")
                ,"Licence","N/A",
                Collections.emptyList());

    }
}
