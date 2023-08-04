package com.Akshayblog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Akshayblog.Entities.Category;
import com.Akshayblog.Entities.User;
import com.Akshayblog.Payloads.UserDto;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	User save(UserDto user);

	

}
