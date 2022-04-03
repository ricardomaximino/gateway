package com.brasatech.gateway.route;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
public class UriConfiguration {

    @Getter
    @Setter
    private String httpbin = "http://httpbin.org:80";

    @Getter
    @Setter
    private String serverOne= "lb://server-one";

}
