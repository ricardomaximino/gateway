package com.brasatech.gateway.route;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
public class UriConfiguration {

    @Getter
    @Setter
    private String httpbin = "http://httpbin.org:80";

    @Getter
    @Setter
    private String serverOne = "lb://server-one";
    
    
    @Getter
    @Setter
    private String nginx = "http://brasatech.es:81";

    @Getter
    @Setter
    private String keycloak = "https://brasatech.es:9443";

    @Getter
    @Setter
    private String thymeleaf = "lb://thymeleaf";

}
