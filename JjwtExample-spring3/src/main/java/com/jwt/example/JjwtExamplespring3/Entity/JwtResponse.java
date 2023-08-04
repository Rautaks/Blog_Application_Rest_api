package com.jwt.example.JjwtExamplespring3.Entity;

import lombok.Builder;
@Builder
public class JwtResponse {

     private String jwttoken;
	
     private String username;
	
	
	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}




	


	
}
