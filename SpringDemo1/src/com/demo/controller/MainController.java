package com.demo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Bank;
import com.demo.model.Customer;
import com.demo.service.BankService;
import com.demo.service.CustomerService;

@Controller
public class MainController {
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private BankService bankService;
	
	@RequestMapping("/")
	public String showHome(Model model, HttpSession session){
		
		model.addAttribute("msg", "Hi from Controller");
		
		return "index";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView showWelcome(HttpServletRequest request ){
		 
		Bank bank = bankService.fetchBank();
		
		List<Customer> list = cs.fetchCustomers();
		bank.setcLst(list);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bank", bank);
		
		mav.setViewName("welcome");
		return mav;
	}
}
