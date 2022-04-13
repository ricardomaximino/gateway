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
    private String serverOne= "lb://server-one";

}
