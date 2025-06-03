package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity
                .csrf().disable()
                .authorizeRequests(
                        auth -> auth
                                .antMatchers("/api/students/**").permitAll()
                                .antMatchers("/api/teachers/**").permitAll()
                                .antMatchers("/api/addresses/**").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement((sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                //.httpBasic(Customizer.withDefaults())
                .build();
    }
}