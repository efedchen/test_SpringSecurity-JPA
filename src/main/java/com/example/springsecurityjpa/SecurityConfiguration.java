package com.example.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailService userDetailsService;

    //reaches userDetailClass to retrive login data
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
//                .and().withUser("user1").password("password").roles("ADMIN").and();
    }

    //allows only certain roles to access certain web addresses
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").access("hasRole('USER')")
//                .antMatchers("/user").hasRole("USER")
                .and().formLogin();
        http.logout().logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
