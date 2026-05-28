package com.eazybytes.jobportal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PathsConfig {

    @Bean(name = "publicPaths")
    public List<String> publicPaths() {
        return List.of(
                "/api/contacts/**",
                "/api/auth/login/**",
                "/api/auth/register/**",  // ← Change this line
                "/api/csrf-token/**",
                "/swagger-ui/**",
                "/api/v3/api-docs/**",
                "/swagger-resources/**",
                "/webjars/**"
        );
    }

    @Bean(name = "securedPaths")
    public List<String> securedPaths() {
        return List.of(
                "/api/**",
                "/api/companies/**"
        );
    }

}