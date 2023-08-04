package com.jwt.example.JjwtExamplespring3.Service;

import java.util.*;
import com.jwt.example.JjwtExamplespring3.Entity.User;


import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private List<User> store = new ArrayList<>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(), "Akshay", "akahay2017@gmail.cm"));
		store.add(new User(UUID.randomUUID().toString(), "Avinash", "avinash@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Avntika", "avantika3415@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Anmol", "anmol@gmail.com"));
	}
	
	public List<User> getUsers()
	{
		return this.store;
	}

}
