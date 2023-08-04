package com.Akshayblog.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfigurerAdapter {


	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return null;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
	}

	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
