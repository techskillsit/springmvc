package com.myapp.controller;


import java.security.Principal;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.beans.Category;
import com.myapp.beans.Product;
import com.myapp.beans.User;
import com.myapp.model.DBConfig;

@Controller
public class MainController {

	@Autowired
	private User user;
	
	@Autowired
	private DBConfig db;
	
	
	@RequestMapping("/")
	public String showHome(HttpSession session,Authentication authentication){
		//Go to DBConfig and call method fetchCategories()
		//save all categories in the List
		List<Category> categoryList = db.fetchCategories();
		//sort the list
		Collections.sort(categoryList);
		//pass the list to jsp as attribute
		session.setAttribute("categoryList", categoryList);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		session.setAttribute("username", userDetails.getUsername());
		session.setAttribute("authority", userDetails.getAuthorities());
		
		return "index";
	}
	
	@RequestMapping("/login")
	public String showLogin(){
		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String showLogout(Model model){
		model.addAttribute("action", "logout");
		return "login";
	}
	
	@RequestMapping("/sign-up")
	public String showSignUp(Model model){
		model.addAttribute("user", user);
		return "sign-up";
	}
	
	@RequestMapping("/sign-up-form")
	public String readSignUpForm(Model model,@Valid User user,  BindingResult result){
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			model.addAttribute("user", user);
			return "sign-up";
		}
		//insert the user credentials in the DB 
		
		db.insertUser(user);
		user.setPassword("--");
		model.addAttribute("msg", "Sign up successfull,please login");
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping("/getProducts")
	public String getProducts(@RequestParam("catId") int catId,Model model){
		//go to DB and call fetchProducts(catId) and save them in List
		List<Product> productList =db.fetchProducts(catId);
		//add productList to attribute and pass on to jsp 
		model.addAttribute("productList", productList);
		return "showProduct";
	}
	
	@RequestMapping("/show-users")
	public String showUsers(){
		return "users";
	}
	
	
}
