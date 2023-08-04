package com.Akshayblog.Services.impl;
import com.Akshayblog.Entities.User;
import com.Akshayblog.Payloads.UserDto;
import com.Akshayblog.Exception.*;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Akshayblog.Repositories.UserRepo;
import com.Akshayblog.Services.UserService;
@Service()
@Repository
public class UserServiceimpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	private Object userDto;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto create(UserDto userDto) {
            User user1 = this. DtoToUser (userDto);
		User savedUser = this.userRepo.save(user1);	
		return this.userTodto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		User user1 =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id",userId));
		
		user1.setName(((User) userDto).getName());
		user1.setEmail(((User) userDto).getEmail());
		user1.setPassword(((User) userDto).getPassword());
		user1.setAbout(((User) userDto).getAbout());
		
		User updatedUser = this.userRepo.save(user1);
		UserDto userDto1= this.userTodto(updatedUser);
		
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		return this.userTodto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDto= users.stream().map(user->this.userTodto(user)).collect(Collectors.toList());
		
		return userDto;
	}

	@Override
	public void deleteUser(Integer UserId) {
		
		User user =this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User", "Id", UserId));
		this.userRepo.delete(user);
		

	}
	
	private  User DtoToUser (UserDto userDto)
	{
		User user= this.modelMapper.map(userDto, User.class);	
		return user;
		
	}
	public UserDto userTodto(User user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return userDto;
		
	}

}
		
		
//	    userDto.setId(user.getId());
//	    userDto.setName(user.getName());
//	    userDto.setEmail(user.getEmail());
//	    userDto.setPassword(user.getPassword());
//	    userDto.setAbout(user.getAbout());
		
//		user.setId(userDto.getId(0));
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());

