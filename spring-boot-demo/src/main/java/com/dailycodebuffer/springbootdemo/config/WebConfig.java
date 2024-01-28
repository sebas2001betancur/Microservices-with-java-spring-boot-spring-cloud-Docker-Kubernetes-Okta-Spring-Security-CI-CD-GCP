package com.dailycodebuffer.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .parameterName("mediaType")
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML) //para imprimir la informacion en formato xml: localhost:8081/employees?mediaType=xml
                .mediaType("json", MediaType.APPLICATION_JSON);  //para imprimir la informacion en formato json: localhost:8081/employees?mediaType=json
    }
}
