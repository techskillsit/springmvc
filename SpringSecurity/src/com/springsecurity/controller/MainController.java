package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
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
	public String showSignUp() {
		return "signup";
	}
}
