package com.brasatech.gateway.route;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class RouteConfiguration {

    @Bean
    public UriConfiguration uriConfiguration(){
        return new UriConfiguration();
    }
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration){
        return  builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(uriConfiguration.getHttpbin()))
                .route(p -> p
                        .host("*.circuitbreaker.com")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                        .uri(uriConfiguration.getHttpbin()))
                .route(p -> p
                        .path("/config")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                                .uri(uriConfiguration.getNginx()))
                .route(p -> p
                        .path("/")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                                .uri(uriConfiguration.getKeycloak()))
                .route(p -> p
                        .path("/keycloak/*")
                        .uri(uriConfiguration.getKeycloak()))
                .route(p -> p
                        .path("/public/*")
                        .uri(uriConfiguration.getThymeleaf()))
                .route(p -> p
                        .path("/private/*")
                        .uri(uriConfiguration.getThymeleaf()))
                .route(p -> p
                        .path("/webjars/**", "/js/**", "/css/**", "/image/**", "/assets/**")
                        .uri(uriConfiguration.getThymeleaf()))
                .build();
    }
}
