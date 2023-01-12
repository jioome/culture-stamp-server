package com.culturestamp.back.auth.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "https://ec2-3-35-144-181.ap-northeast-2.compute.amazonaws.com", "https://ec2-3-35-144-181.ap-northeast-2.compute.amazonaws.com:8080")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "OPTIONS")
            .allowCredentials(true)
            .allowedHeaders("*")
            .maxAge(3000);
    }
}

