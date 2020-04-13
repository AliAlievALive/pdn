package ru.asu.pdn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                    .withUser("admin")
                    .password("$2a$10$lknpA7xIYjTMTWndGw1Veul4ncNnAr2FxFeiZ4vZLtXCQF8JTfykq")
                    .roles("ADMIN")
                .and()
                    .withUser("Elena")
                    .password("$2a$10$Uul4OyvYLmtsNoAPLhXGTe2kGjpuQblRn/CW1738fJlo9W7iEqBzG")
                    .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/new").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/edit/*", "/delete/*").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .httpBasic()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}