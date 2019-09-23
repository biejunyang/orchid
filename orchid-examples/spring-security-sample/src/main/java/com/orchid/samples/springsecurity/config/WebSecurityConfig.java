package com.orchid.samples.springsecurity.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//Spring Security安全认证机制
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * Spring Securtiry安全机制默认配置：
         *  1、所有请求都需要认证
         *  2、使用表单认证的方式
         *  3、使用内置的基础http表单认证方式：
         *      a：登录页面url：GET /login
         *      b：登录认证url：POST /login
         *      c：登录失败跳转url：GET /login?error
         *      d：注销确认页面：GET /logout
         *      e：注销登录：POST /logout
         *      f：注销成功页面：GET /login?logout
         */
//        super.configure(http);
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();

    }
}
