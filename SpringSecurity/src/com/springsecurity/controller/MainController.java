package com.springsecurity.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsecurity.DB.DBConfig;
import com.springsecurity.model.User;
 

@Controller
public class MainController {
	 
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DBConfig db;
	@RequestMapping("/")
	public String showHome() {
		 return "home";
	}
	
	@RequestMapping("/show-report")
	public String showReport() {
		return "report";
	}

	@RequestMapping("/show-users")
	public String showUsers() {
		return "users";
	}

	@RequestMapping("/sign-up")
	public String showSignUp(Model model) {
		 User user = new User();
		 user.setName("ron");
		 user.setUsername("ron");
		 user.setPassword(passwordEncoder.encode("1234"));
		 user.setRole("USER");
		 db.insertUser(user);
		 model.addAttribute("user", user);
		return "home";
	}
}
