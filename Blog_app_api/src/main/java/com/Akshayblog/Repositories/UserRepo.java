package com.Akshayblog.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Akshayblog.Entities.User;
import com.Akshayblog.Payloads.UserDto;

public  interface UserRepo extends JpaRepository<User, Integer>{

	User save(UserDto user);

	//User save1(UserDto user);
	
	Optional<User> findByEmail(String email);

}

