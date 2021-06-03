package com.app.lexicographer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.app.lexicographer.model.Role;
import com.app.lexicographer.service.DashboardService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(value = "/roles")
public class RolesController {

	@Autowired
	DashboardService dashboardService;

	@ModelAttribute
	public Role initCategory() {
		return new Role();
	}

	@GetMapping(value = "")
	public ModelAndView getMethodName() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("roles", dashboardService.getAllRoles());
		mav.setViewName("roles");
		return mav;
	}

	@PostMapping(value = "")
	public String addRole(@ModelAttribute Role role,Model model) {
		if(role.getROLE().isEmpty()) {
			model.addAttribute("NotRole", "Role values is not empty.");
			model.addAttribute("roles",dashboardService.getAllRoles());
			return "roles";
		}
		
		role.setROLE("ROLE_" + role.getROLE().toUpperCase());
		dashboardService.createRole(role);
		return "redirect:/roles";
	}

	// Get Details Page for Type
	@GetMapping(value = "/role/details/{Id}")
	public ModelAndView getRoleDetails(@PathVariable Long Id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("role", dashboardService.findByIdRole(Id));
		mav.setViewName("roledetails");
		return mav;
	}

	// Delete Category
	@GetMapping(value = "/role/delete/{Id}")
	public String removeType(@ModelAttribute Role role) {
		dashboardService.deleteRole(role.getId());
		return "redirect:/roles";
	}

	// Update for Category
	@PostMapping(value = "/role/update/{Id}")
	public String updateType(@ModelAttribute Role role, Model model) {
		if(role.getROLE().isEmpty()) {
			model.addAttribute("NotRole", "Role values is not empty.");
			model.addAttribute("roles",dashboardService.getAllRoles());
			return "roledetails";
		}		
		role.setROLE("ROLE_" + role.getROLE().toUpperCase());
		dashboardService.updateRole(role);
		return "redirect:/roles";
	}

}
