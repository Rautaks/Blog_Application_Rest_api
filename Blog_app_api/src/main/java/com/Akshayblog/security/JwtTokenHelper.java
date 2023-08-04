package com.Akshayblog.security;

import java.util.Date;
import java.util.function.Function;
import java.util.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtTokenHelper {
	
	public static final long JWT_TOKEN_VALIDITY = 5* 60*60;
	
	private String secret = "jwtTokenKey";
	
	//retrieve username from jwt token
	public String getUsernameFromToken(String token)
	{
		return getClaimsFromToken(token, Claims::getSubject);
	}
	

	//Retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token)
	{
		return getClaimsFromToken(token, Claims::getExpiration);
	}
	
	//Retrieve all jwt token
	public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver)
	{
		final Claims claims = getAllClaimsFromToken (token);
		return claimsResolver.apply(claims);
	}
	
	//for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token)
	{
		return Jwts.parser().setSigningKey(secret). parseClaimsJws(token).getBody();
				
	}
	
	//check if the token has expired
	private Boolean isTokenExpired(String token)
	{
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	// Generate token for user
	public String generateToken(UserDetails userDetails)
	{
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	//while creating the Token-
	//1. Define claims of the token, like Issuer, Expiration, subject, and the 
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3.According to jws Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose
	//compaction of the jwt to url-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject)
	{
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt
				(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY *1000 * 60 * 60 * 10))  
				.signWith(SignatureAlgorithm.HS512, secret).compact();			
	}
	
	//validate token
	public Boolean validateToken(String token, UserDetails userDetails)
	{
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
	}
	
	
}