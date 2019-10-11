package com.orchid.examples.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class OAuth2AuthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2AuthServerApp.class, args);
    }




    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}