package com.Akshayblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Akshayblog.Payloads.JwtAuthRequest;
import com.Akshayblog.Payloads.JwtAuthResponce;
import com.Akshayblog.security.JwtTokenHelper;
import com.Akshayblog.security.UsernamePasswordAuthenticationToken;
@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponce> createToken(
			@RequestBody JwtAuthRequest request
			
			)
	{
		this.authenticate(request.getUsername(), request.getPassword());
		
	    UserDetails userDetails =this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponce response = new JwtAuthResponce();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponce>(response, HttpStatus.OK);
	}

	private void authenticate(String  getusername, String getpassword) {
		
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(getusername , getpassword);
	   
		this.authenticationManager.authenticate(authenticationToken);
	    
	   
	}

	
	
	

}
