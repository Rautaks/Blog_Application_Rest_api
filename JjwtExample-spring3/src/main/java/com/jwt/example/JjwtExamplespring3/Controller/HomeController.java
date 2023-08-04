package com.jwt.example.JjwtExamplespring3.Controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.example.JjwtExamplespring3.Entity.User;
import com.jwt.example.JjwtExamplespring3.Service.UserService;

	@RestController
	@RequestMapping("/home")
	public class HomeController {
		
		@Autowired
		private UserService userService;
		
		//  http://localhost:8080/home/users
		
		@GetMapping("/users")
		public List<User> getUser() 
		{
			System.out.println("Getting users");
			
			return this.userService.getUsers();
			
		}
		
		@GetMapping("/currenct-user")
		public String getLoggedInUser(Principal principal)
		{
			return principal.getName();
		}
		
	}

