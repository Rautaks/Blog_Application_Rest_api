package com.Akshayblog.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor


public class UserDto {
	
	private int Userid;
	
    @NotEmpty
    @Size(min=4, message="User name must be getter than 4 chareacter")
	private String name;
    
	@Email(message = "Email address is not valid")
	private String email;
	
	@NotEmpty(message="Password is not to be empty")
	@Size(min = 3, max = 10, message="Password must maxium of 6 char to 10 char")
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{")
	private String password;
	
	@NotEmpty
	private String about;
	
	
	
	public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.Userid = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;		
	}
	public UserDto() {
		super();
		
	}
	public int getId()
	{
		return Userid;
	}
	public void setId(int id) {
		this.Userid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
	@Override
	public String toString() {
		return "UserDto [id=" + Userid + ", name=" + name + ", email=" + email + ", password=" + password + ", about="
				+ about + "]";
	}
	
      
	
}
