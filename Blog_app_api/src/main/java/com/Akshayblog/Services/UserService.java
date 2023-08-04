package com.Akshayblog.Services;

import java.util.List;

import com.Akshayblog.Entities.User;
import com.Akshayblog.Payloads.UserDto;

public interface  UserService {

	UserDto create(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer UserId);
}
