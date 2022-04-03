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
        String httpUri = uriConfiguration.getHttpbin();
        String serverOne = uriConfiguration.getServerOne();
        return  builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.circuitbreaker.com")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .route(p -> p
                        .path("/public/*")
                        .uri(serverOne))
                .route(p -> p
                        .path("/private/*")
                        .uri(serverOne))
                .build();
    }
}
