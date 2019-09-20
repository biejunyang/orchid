package com.orchid.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/docker-example/**")
////                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://localhost:8080/hello"))
////                .route(p -> p
////                        .host("*.lemon.com")
////                        .filters(f -> f.hystrix(config -> config
////                                .setName("test")
////                                .setFallbackUri("forward:/fallback")))
////                        .uri(" http://localhost:8866"))
//                .build();
//    }
}
