/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TutoriasBelieve;


import com.TutoriasBelieve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 *
 * @author fabia
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    
    @Autowired 
    private UserService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    
        return new BCryptPasswordEncoder();
    
    }
    
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);

        return daoAuthenticationProvider;
    }

    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }
    
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "VENDEDOR", "USER")
                .and()
                .withUser("vendedor")
                .password("{noop}123")
                .roles("VENDEDOR", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
    
    }
    */
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
    
        auth.authenticationProvider(authenticationProvider());
    
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    
        
        http.authorizeRequests()
                .antMatchers("/personas")
                .hasRole("ADMIN")
                .antMatchers("/personasN")
                .hasAnyRole("ADMIN", "STUD")
                .antMatchers("/personas", "/personasN")
                .hasAnyRole("STUD", "PROF", "ADMIN")
                .and()
                .formLogin()
                .loginProcessingUrl("/signin").permitAll();
    
    
    }
    
    
    
    
}
