package com.virgo.backend.configuration.security;

import com.virgo.backend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.virgo.backend.configuration.security.ApplicationUserRole.*;
import static com.virgo.backend.configuration.security.ApplicationUserPermission.*;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //indicates that we want to use the annotation for permissions
public class LibraSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        // [!] The order we put the ant matchers MATTER. PAY ATTENTION [!]
        http
                .csrf().disable()
                .authorizeRequests() // vogliamo richieste autorizzate
                .antMatchers("/index.hmtl").permitAll()// permette di dire a spring security quali sono gli url su cui non deve richiedere username e password. Gli url whitelistati
                .antMatchers("/user/**").hasRole(UTENTE.name())
                .antMatchers("/user/**").hasAnyRole(ADMIN.name())
                .antMatchers(HttpMethod.GET, "/user/**").hasAuthority(USER_READ.getPermission())// role based authentication
                .anyRequest() // ogni richiesta deve essere autenticata
                .authenticated() // qui diciamo che ogni richiesta deve essere autenticata
//                .and()
//                .httpBasic(); //vogliamo che il meccanismo che forzi l'autenticazione del client sia quello base
                .and()  // -> inizia il codice che indica a spring boot che tipo di pagina custom utilizzare per il login
                .formLogin()
                .loginPage("/login").permitAll();

    }

    @Override
    @Bean
    // È il metodo da cui si preleva l'user dal database
    protected UserDetailsService userDetailsService() {

        UserDetails antonioUser = User.builder() // simple user
                .username("Antonio")
                .password(passwordEncoder.encode("password"))
//                .roles(UTENTE.name())
                .authorities(UTENTE.getGrantedAuthority())
                .build(); // un ruolo è solo una vista di alto livello di tutti gli utenti che si hanno nel sistema
                // per ogni utente ci deve essere un ruolo che rappresenta autorizzazioni e permessi

        UserDetails adminUser = User.builder() // admin user
                .username("Marco")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthority())
                .build();

        UserDetails adminTraineeUser = User.builder() // admin trainee user per similare un admin che non ha tutti i permessi
                .username("Tom")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMINTRAINEE.name()).build(); //ROLE_ADMINTRAINEE
                .authorities(ADMINTRAINEE.getGrantedAuthority())
                .build();

        return new InMemoryUserDetailsManager(antonioUser, adminUser);
    }
}
