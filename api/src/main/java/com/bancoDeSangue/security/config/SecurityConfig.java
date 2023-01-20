package com.bancoDeSangue.security.config;

import static org.springframework.session.web.http.HeaderHttpSessionIdResolver.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.session.web.http.HttpSessionIdResolver;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig{

    @Bean
    public HttpSessionIdResolver httpSessionIdResolver (){
        return xAuthToken();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    };


    @Bean
    public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/usuario/criar","/usuario/criarLista", "/usuario/login")
                .permitAll().and()
                .authorizeRequests()
                .anyRequest()
                .authenticated().and()
                .httpBasic();

        return http.build();
    }
}
