package com.brasatech.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecuriryConfig{

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http.authorizeExchange()
            .pathMatchers("/actuator/**","/public/**")
            .permitAll()
        .and()
            .authorizeExchange()
            .anyExchange()
            .authenticated()
        .and()
            .oauth2Login();
        return http.build();
    }
    
}
