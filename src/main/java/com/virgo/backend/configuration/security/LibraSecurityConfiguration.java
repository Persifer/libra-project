package com.virgo.backend.configuration.security;

import com.virgo.backend.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class LibraSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .authorizeHttpRequests() // vogliamo richieste autorizzate
                .antMatchers("/","/index.hmtl") // permette di dire a spring security quali sono gli url su cui non deve richiedere username e password. Gli url whitelistati
                .permitAll()
                .anyRequest() // ogni richiesta deve essere autenticata
                .authenticated() // qui diciamo che ogni richiesta deve essere autenticata
                .and()
                .httpBasic(); //vogliamo che il meccanismo che forzi l'autenticazione del client sia quello base

    }

    @Override
    @Bean
    // È il metodo da cui si preleva l'user dal database
    protected UserDetailsService userDetailsService() {

        UserDetails antonioUser = User.builder()
                .username("Antonio")
                .password("password")
                .roles(Constants.USEROLE).build();

        return new InMemoryUserDetailsManager(antonioUser);
    }
}
