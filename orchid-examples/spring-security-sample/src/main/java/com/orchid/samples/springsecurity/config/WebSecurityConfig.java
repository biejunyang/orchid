package com.orchid.samples.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 1、请求安全规则设置：设置哪些请求需要保护
     * 2、认证方式设置：表单认证、oauth2.o认证、openid认证
     * 3、请求安装设置其他功能：如跨域；记住登录状态；登录注销等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }



    /**
     * 认证管理器：具体用户认证实现:
     *   1、In-Memory Authentication内存用户认证,从内容中获取用户信息，注意设置密码时，需要执行密码的加密格式
     *   2、JDBC Authentications数据源认证
     *   3、LDAP Authentication
     *   4、自定义认证方式，两种实现：
     *      a、spring容器中注入AuthenticationProvider对象
     *      b、spring容器中注入UserDetailsService对象
     *         注意只有当AuthenticationManagerBuilder对象没有使用其他认证方式时，以上两种自定义认证方式才能生效，
     *         并且AuthenticationProvider认证会覆盖UserDetailsService认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }




    @Bean
    public UserDetailsService myUserDetailsService(){
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                List<SimpleGrantedAuthority> authorities=new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ADMIN"));
                return new User("zhangsan", new BCryptPasswordEncoder().encode("123456"), authorities);
            }
        };
    }



    /**
     * 密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

        //托管编码器
//        DelegatingPasswordEncoder delegatingPasswordEncoder=(DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
//        return  delegatingPasswordEncoder;
    }



    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
