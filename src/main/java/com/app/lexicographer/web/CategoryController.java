package com.app.lexicographer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.lexicographer.model.Category;
import com.app.lexicographer.service.DashboardService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private DashboardService dashboardService;

	@ModelAttribute
	public Category initCategory() {
		return new Category();
	}

	@GetMapping("")
	public ModelAndView getCategories() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categories",dashboardService.getAllCategories());
		mav.setViewName("categories");
		return mav;
	}

	// Create new category method
	@PostMapping(value = "")
	public String saveCategory(@ModelAttribute Category category) {
		dashboardService.createCategory(category);
		return "redirect:/categories";
	}

	// Get Details Page for Type
	@GetMapping(value = "/category/details/{Id}")
	public ModelAndView getCategoryDetails(@PathVariable Long Id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("category", dashboardService.findByIdCategory(Id));
		mav.setViewName("categorydetails");
		return mav;
	}

	// Delete Category
	@GetMapping(value = "/category/delete/{Id}")
	public String removeType(@ModelAttribute Category category) {
		dashboardService.deleteCategory(category.getId());
		return "redirect:/categories";
	}

	// Update for Category
	@PostMapping(value = "/category/update/{Id}")
	public String updateType(@ModelAttribute Category category) {
		dashboardService.updateCategory(category);
		return "redirect:/categories";
	}
}
