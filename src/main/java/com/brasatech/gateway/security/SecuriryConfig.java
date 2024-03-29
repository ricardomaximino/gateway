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
            .pathMatchers("/keycloak/**","/actuator/**", "/get/**", "/delay/**").permitAll()
            .pathMatchers("/webjars/**", "/js/**", "/css/**", "/image/**", "/assets/**").permitAll()
        .and()
            .authorizeExchange()
            .anyExchange()
            .authenticated()
        .and()
            .oauth2Login();
            
        return http.build();
    }
    
}
