package com.brasatech.gateway.route;

// import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
// import static com.github.tomakehurst.wiremock.client.WireMock.get;
// import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
// import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

// import java.nio.charset.StandardCharsets;

// import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
// import org.springframework.test.web.reactive.server.WebTestClient;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"httpbin=https://localhost:${wiremock.server.port}"})
// @AutoConfigureWireMock(port = 0)
class RouteConfigurationTest {


    
     @Test
     public void routes_get() {}
    // @Autowired
    // private WebTestClient webClient;

    // @Test
    // public void routes_get() {
    //     //Stubs
    //     stubFor(get(urlEqualTo("/get"))
    //         .willReturn(aResponse()
    //         .withBody("{\"headers\":{\"Hello\":\"World\"}}")
    //         .withHeader("Content-Type", "application/json")));


    //     webClient
    //       .get().uri("/get")
    //       .exchange()
    //       .expectStatus().isOk()
    //       .expectBody()
    //       .jsonPath("$.headers.Hello").isEqualTo("World");
    // }

    // @Test
    // public void routes_delay() {
    //     //Stubs
    //     stubFor(get(urlEqualTo("/delay/3"))
    //         .willReturn(aResponse()
    //         .withBody("no fallback")
    //         .withFixedDelay(3000)));

    //     webClient
    //       .get().uri("/delay/3")
    //       .header("Host", "www.circuitbreaker.com")
    //       .exchange()
    //       .expectStatus().isOk()
    //       .expectBody()
    //       .consumeWith(
    //         response -> Assertions.assertThat(response.getResponseBody()).isEqualTo("fallback".getBytes(StandardCharsets.UTF_8)));
    // }
}