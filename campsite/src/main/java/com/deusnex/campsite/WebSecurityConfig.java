package com.deusnex.campsite;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	//Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
    
    
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
						.antMatchers("/", "/home").permitAll()	
						.anyRequest().authenticated()
						.and()
				.formLogin()
						.loginPage("/login")
						.permitAll()
						.and()
				.logout()
						.permitAll();
		}
	
	
	
	
}
