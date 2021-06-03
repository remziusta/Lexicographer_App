package com.app.lexicographer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.lexicographer.model.User;
import com.app.lexicographer.service.DashboardService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	DashboardService dashboardService;

	@ModelAttribute
	public User initUser() {
		return new User();
	}

	@GetMapping(value = "")
	public ModelAndView getUsers() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", dashboardService.getAllUsers());
		mav.setViewName("users");
		return mav;
	}

	@GetMapping(value = "/adduser")
	public ModelAndView getAddUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("roles", dashboardService.getAllRoles());
		mav.setViewName("adduser");
		return mav;
	}

	@PostMapping(value = "/user/new")
	public String postAddNewUser(@ModelAttribute User user, Model model) {
		if (user.getUsername().isEmpty()) {
			model.addAttribute("userError", "Username value is not empty.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "adduser";
		}
		if (user.getUsername().length() < 5) {
			model.addAttribute("userminError", "The username value you entered is a min. of 5 characters.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "adduser";
		}
		if (user.getFullname().isEmpty()) {
			model.addAttribute("nameError", "Full Name value is not empty.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "adduser";
		}
		if (user.getFullname().length() < 6 || user.getFullname().length() > 50) {
			model.addAttribute("nameMinEror",
					"The full name value you entered is a min. of 6 characters or a max. of 50 characters.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "adduser";
		}
		if (user.getEmail().isEmpty()) {
			model.addAttribute("emailError", "E-mail value is not empty.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "adduser";
		}
		if (user.getPassword().isEmpty()) {
			model.addAttribute("passError", "Password value is not empty.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "adduser";
		}
		if (user.getRole().getId() == null) {
			model.addAttribute("roleError", "Please select a role");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "adduser";
		}
		user.getEmail().trim();
		user.getFullname().trim();
		user.getPassword().trim();
		user.getUsername().trim();
		user.setRole(dashboardService.findByIdRole(Long.valueOf(user.getRole().getId())));
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		dashboardService.createUser(user);
		return "redirect:/users";
	}

	@GetMapping(value = "/user/details/{id}")
	public ModelAndView getDetails(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", dashboardService.findByIdUser(id));
		mav.addObject("roles", dashboardService.getAllRoles());
		mav.setViewName("userdetails");
		return mav;
	}

	// Delete Category
	@GetMapping(value = "/user/delete/{id}")
	public String removeUser(@ModelAttribute User user) {
		dashboardService.deleteUser(user.getId());
		return "redirect:/users";
	}

	// Update for Category
	@PostMapping(value = "/user/update/{id}")
	public String updateUser(@ModelAttribute User user, Model model) {
		if (user.getUsername().isEmpty()) {
			model.addAttribute("userError", "Username value is not empty.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "userdetails";
		}
		if (user.getUsername().length() < 5) {
			model.addAttribute("userminError", "The username value you entered is a min. of 5 characters.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "userdetails";
		}
		if (user.getFullname().isEmpty()) {
			model.addAttribute("nameError", "Full Name value is not empty.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "userdetails";
		}
		if (user.getFullname().length() < 6 || user.getFullname().length() > 50) {
			model.addAttribute("nameMinEror",
					"The full name value you entered is a min. of 6 characters or a max. of 50 characters.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "userdetails";
		}
		if (user.getEmail().isEmpty()) {
			model.addAttribute("emailError", "E-mail value is not empty.");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "userdetails";
		}
		if (user.getRole().getId() == null) {
			model.addAttribute("roleError", "Please select a role");
			model.addAttribute("roles", dashboardService.getAllRoles());
			return "userdetails";
		}
		user.getEmail().trim();
		user.getFullname().trim();
		user.getPassword().trim();
		user.getUsername().trim();
		
		dashboardService.updateUser(user);
		return "redirect:/users";
	}

	

}
