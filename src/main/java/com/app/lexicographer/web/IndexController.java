package com.app.lexicographer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.lexicographer.model.User;
import com.app.lexicographer.service.DashboardService;

@Controller
@RequestMapping(value = "")
public class IndexController {
	
	@Autowired
	DashboardService dashboardService;
	
	@ModelAttribute
	public User initUser() {
		return new User();
	}
	
	@GetMapping(value = "")
	public ModelAndView getMainPage() {
		ModelAndView mav  = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping(value = "/login")
	public String getLogin(Model model, String error, String logout,String registerSuccess ) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is valid");
		}
		if (logout != null) {
			model.addAttribute("message", "You have been logout success");
		}if (registerSuccess != null) {
			model.addAttribute("registerSuccess", "Register Success...");
		}
		return "login";
	}
	
	@GetMapping(value = "/register")
	public ModelAndView getRegisterPage() {
		ModelAndView mav  = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute User user,Model model) {
		if(user.getEmail().isEmpty()) {
			model.addAttribute("emailerror", "Check your email");			
			return "register";
		}else if(user.getFullname().isEmpty()){
			model.addAttribute("fullname", "Check your fullname");
			return "register";
		}else if(user.getPassword().isEmpty()){
			model.addAttribute("passerror", "Check your password");
			return "register";
		}else if(user.getUsername().isEmpty()) {
			model.addAttribute("usererror", "Check your username");
			return "register";
		}else {			
			BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder();
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(true);
			user.setRole(dashboardService.findByRoleNameRole("ROLE_USER"));
			dashboardService.createUser(user);
			model.addAttribute("registerSuccess", "Register Success...");
			return "redirect:/login";
		}
		
	}
	
}
