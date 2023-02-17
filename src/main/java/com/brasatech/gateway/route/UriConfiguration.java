package com.brasatech.gateway.route;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;


@ConfigurationProperties
@Data
public class UriConfiguration {

    private String httpbin = "http://httpbin.org:80";

    private String serverOne= "lb://server-one";

    private String thymeleaf= "https://localhost:8443";

}
