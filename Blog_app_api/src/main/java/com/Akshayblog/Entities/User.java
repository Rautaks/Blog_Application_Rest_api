package com.Akshayblog.Entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

import com.Akshayblog.Entities.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user1")
@NoArgsConstructor
public class User implements UserDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Userid;
	@Column(name = "User_Name", nullable = false, length = 100)
	private String name;
	private String email;
	private String password;
	private String about;

	public User(int id, String name, String email, String password, String about) {
		super();
		this.Userid = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
	joinColumns = @JoinColumn(name = "user", 
	referencedColumnName = "Userid"),
	inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	@Override
	public String toString() {
		return "User [id=" + Userid + ", name=" + name + ", email=" + email + ", password=" + password + ", about="
				+ about + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>authorites =this.roles.stream()
				.map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authorites;
	}

	@Override
	public String getUsername() {
		
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
