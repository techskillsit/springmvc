package com.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public String showHome(Model model, HttpSession session){
		
		model.addAttribute("msg", "Hi from Controller");
		
		return "index";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView showWelcome(HttpServletRequest request ){
		ModelAndView mav = new ModelAndView();
		String msg = request.getParameter("msg");
		mav.addObject("msg", msg);
		
		mav.setViewName("welcome");
		return mav;
	}
}
