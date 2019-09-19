package com.orchid.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp {


    public static void main(String[] args){

//        SpringApplication.run(EurekaServerApp.class, args);

        new SpringApplicationBuilder(EurekaServerApp.class).run(args);
    }


}
