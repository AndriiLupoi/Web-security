package org.lupoi.security25.config;/*
    @author user
    @project security25
    @class SecurityConfig
    @version 1.0.0
    @since 30.09.2025 - 13.21
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // відключив CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // будь-який запит потребує лише логін/пароль
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
