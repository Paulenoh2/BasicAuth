package com.example.demo.security;

import com.example.demo.services.Impl.UserClassService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(){

                return new UserClassService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return  http
               .csrf()
                .disable()
                .authorizeHttpRequests().requestMatchers("/api/new","/api/welcome").permitAll()
                //.authorizeHttpRequests().requestMatchers("/api/edit","/api/delete/{id}","/api/new","/api/get/{id}","/api/all").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/api/all","/api/get/{id}","/api/delete/{id}","/api/edit").authenticated()
                .and()
                .formLogin().and().build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
