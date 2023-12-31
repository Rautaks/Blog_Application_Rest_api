package com.Akshayblog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Akshayblog.Entities.User;
import com.Akshayblog.Exception.ResourceNotFoundException;
import com.Akshayblog.Repositories.UserRepo;

@Configuration
@Service()
public class CustomeUserDetailService implements UserDetailsService {

	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername( @Lazy String username) throws UsernameNotFoundException {
		
		//loading user from database by username
		User user = this.userRepo.findByEmail(username)
		.orElseThrow(()->new ResourceNotFoundException("user", "email: "+username, 0));
		return user;
	}
	
	

}
