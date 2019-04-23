package com.myapp.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class User {
	
	@NonNull
	@Pattern(regexp="\\w+",message="invalid name")
	private String name;
	
	
	@NonNull
	@Pattern(regexp="\\w+",message="invalid username")
	private String username;
	
	@Size(min=4,max=10, message="invalid password must be between 4 to 10 characters")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
