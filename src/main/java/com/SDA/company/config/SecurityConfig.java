package com.SDA.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN","USER")
                .and()
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
//                .antMatchers("/company/create").hasRole("ADMIN")
//                .antMatchers("/company/getAll").hasRole("USER")
//                .anyRequest().authenticated()
                .anyRequest().permitAll() // <- pentru a dezactiva temporar "auenticater" -ul se lasa aceasta linie activa;
                .and()
                .httpBasic();

        httpSecurity.csrf().disable().authorizeRequests()
                .and()
                .cors().disable().authorizeRequests();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // <- Criptor parole;
    }
}
