package com.garagonic.goodsin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


/**
 * @author <a href="mailto:izebit@gmail.com">Artem Konovalov</a> <br/>
 *         Creation date: 6/25/17.
 * @since 1.0
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {

        builder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_name, password, active from giuser where user_name=?")
        .authoritiesByUsernameQuery("select user_name, roles, active from giuser where user_name=?");
    }

    @Override
    protected void configure(HttpSecurity config) throws Exception {

        config.csrf().disable().authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").access("hasRole('USER') or hasRole('ADMIN')")
                .and()
                .formLogin()
                .and()
                .logout();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
