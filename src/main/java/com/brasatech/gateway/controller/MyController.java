package com.brasatech.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {

    @GetMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }
}
