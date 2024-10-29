package com.example.role_authorities.config;


import com.example.role_authorities.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((authorize)->{
            authorize.requestMatchers("/h2-console/**").permitAll();

            authorize.requestMatchers(GET, "/admin/**").hasAuthority("ADMIN_Read")
                    .requestMatchers(POST, "/admin/**").hasAuthority("ADMIN_Write")
                    .requestMatchers(GET, "/manager/**").hasAuthority("MANAGER_Read")
                    .requestMatchers(POST, "/manager/**").hasAuthority("MANAGER_Write");

            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        http.headers(headers-> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
