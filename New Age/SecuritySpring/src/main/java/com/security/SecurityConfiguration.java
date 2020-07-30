package com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").hasRole("ADMIN")
		.and().formLogin();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		super.configure(auth);
		auth.inMemoryAuthentication()
		.withUser("jansi")
		.password("jansirani").roles("USER")
		.and()
		.withUser("jenni")
		.password("jennifer")
		.roles("ADMIN");
		
	}

	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
