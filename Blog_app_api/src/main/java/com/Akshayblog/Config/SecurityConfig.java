package com.Akshayblog.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.Akshayblog.security.CustomeUserDetailService;
import com.Akshayblog.security.JwtAuthenticationEntryPoint;
import com.Akshayblog.security.JwtAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@SuppressWarnings("deprecation")
@Service
@Configuration
@Qualifier
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private  CustomeUserDetailService customeUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	 @Autowired
	  private JwtAuthenticationFilter jwtAuthenticationFilter;

	  @Override
	protected void configure(HttpSecurity http)  throws Exception
	{
        http
                .csrf(withDefaults())
                .securityMatcher("/api/v1/auth/login")
                .authorizeHttpRequests(requests -> requests
                 .anyRequest()
                 .authenticated())
               .exceptionHandling()
               .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService (this.customeUserDetailService).passwordEncoder(passwordEncoder());
	}

          @Bean
          public PasswordEncoder passwordEncoder() {
	        PasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();
	        return PasswordEncoder;
	    }

	  @Bean
	  @Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
		    return super.authenticationManagerBean();
		}


}
