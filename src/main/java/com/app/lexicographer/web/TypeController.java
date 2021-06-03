package com.app.lexicographer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.lexicographer.model.Type;
import com.app.lexicographer.service.DashboardService;

@Controller
@RequestMapping("/types")
public class TypeController {
	
	@Autowired
	private DashboardService dashboardService;
	
	
	@ModelAttribute
	public Type initType() {
		return new Type();
	}
	
	@GetMapping("")	
	public ModelAndView getTypes() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("types",dashboardService.getAllTypes());
		mav.setViewName("types");
		return mav;
	}
	
	// Create new type method
	@PostMapping(value = "")
	public String saveType(@ModelAttribute Type type,Model model) {
		if(type.getTYPE().isEmpty()) {
			model.addAttribute("NotType", "Type values is not empty.");
			model.addAttribute("types",dashboardService.getAllTypes());
			return "types";
		}
		if(type.getTYPE().length() < 3) {
			model.addAttribute("MinimumError","The type value you entered is a min. of 3 characters.");
			model.addAttribute("types",dashboardService.getAllTypes());
			return "types";
		}
		type.setTYPE(type.getTYPE().toUpperCase());
		dashboardService.createType(type);
		return "redirect:/types";
	}
	
	//Get Details Page for Type
	@GetMapping(value = "/type/details/{Id}")
	public ModelAndView getTypeDetails(@PathVariable Long Id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("type", dashboardService.findByIdType(Id));
		mav.setViewName("typedetails");
		return mav;
	}
	
	//Delete Type 
	@GetMapping(value = "/type/delete/{Id}")
	public String removeType(@ModelAttribute Type type) {
		dashboardService.deleteType(type.getId());
		return "redirect:/types";
	}
	
	//Update for Type
	@PostMapping(value = "/type/update/{Id}")
	public String updateType(@ModelAttribute Type type,Model model) {
		if(type.getTYPE().isEmpty()) {
			model.addAttribute("NotType", "Type values is not empty.");
			model.addAttribute("types",dashboardService.getAllTypes());
			return "typedetails";
		}
		if(type.getTYPE().length() < 3) {
			model.addAttribute("MinimumError","The type value you entered is a min. of 3 characters.");
			model.addAttribute("types",dashboardService.getAllTypes());
			return "typedetails";
		}
		type.setTYPE(type.getTYPE().toUpperCase());
		dashboardService.updateType(type);
		return "redirect:/types";
	}
	

}
