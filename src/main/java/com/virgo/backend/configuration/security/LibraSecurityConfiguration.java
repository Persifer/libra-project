package com.virgo.backend.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LibraSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .authorizeHttpRequests() // vogliamo richieste autorizzate
                .anyRequest() // ogni richiesta deve essere autenticata
                .authenticated() // qui diciamo che ogni richiesta deve essere autenticata
                .and()
                .httpBasic(); //vogliamo che il meccanismo che forzi l'autenticazione del client sia quello base

    }
}
