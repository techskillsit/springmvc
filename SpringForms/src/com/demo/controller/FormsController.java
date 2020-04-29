package com.demo.controller;

 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.User;

@Controller
public class FormsController {
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	// This is a sign-up without spring
	@RequestMapping("/sign-up")
	public String showSignUp() {
		return "sign-up";
	}

	// This is a sign-up with Spring
	@RequestMapping("/sign-up-spring")
	public String showSignUpWithSpring(Model model) {
		model.addAttribute("user", new User());
		return "sign-up-spring";
	}
	
	 
}
