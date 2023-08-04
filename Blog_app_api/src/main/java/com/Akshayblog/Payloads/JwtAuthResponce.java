package com.Akshayblog.Payloads;

//import lombok.Data;


public class JwtAuthResponce {
	
	
	private String token;
	
	public String getToken() {
		return token;
	}

	public JwtAuthResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setToken(String token) {
		this.token = token;
	}

	

}
