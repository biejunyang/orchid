package com.orchid.samples.springsecurity.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig {

//
//    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "basic")
//    @Configuration
//    public static class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
//
//
//    }
//
//
//
//    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "oauth2-login")
//    @Configuration
//    public static class Oauth2SecurityConfig extends WebSecurityConfigurerAdapter{
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
//        }
//    }




}
