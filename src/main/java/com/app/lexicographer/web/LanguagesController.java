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

import com.app.lexicographer.model.Language;
import com.app.lexicographer.service.DashboardService;

@Controller
@RequestMapping("/languages")
public class LanguagesController {
	@Autowired
	private DashboardService dashboardService;

	@ModelAttribute
	public Language initCategory() {
		return new Language();
	}

	@GetMapping("")
	public ModelAndView getLanguages() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("languages",dashboardService.getAllLanguages());
		mav.setViewName("languages");
		return mav;
	}

	// Create new category method
	@PostMapping(value = "")
	public String saveLanguage(@ModelAttribute Language language, Model model) {
		if(language.getLANGUAGE().isEmpty()) {
			model.addAttribute("NotLanguage", "Language values is not empty.");
			model.addAttribute("languages",dashboardService.getAllLanguages());
			return "languages";
		}
		if(language.getLANGUAGE().length() != 2) {
			model.addAttribute("MinimumError","The language value you entered is 2 characters.");
			model.addAttribute("languages",dashboardService.getAllLanguages());
			return "languages";
		}
		language.setLANGUAGE(language.getLANGUAGE().toUpperCase());
		dashboardService.createLanguage(language);
		return "redirect:/languages";
	}

	// Get Details Page for Type
	@GetMapping(value = "/language/details/{Id}")
	public ModelAndView getLanguageDetails(@PathVariable Long Id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("language", dashboardService.findByIdLanguage(Id));
		mav.setViewName("languagedetails");
		return mav;
	}

	// Delete Category
	@GetMapping(value = "/language/delete/{id}")
	public String removeLanguage(@ModelAttribute Language language) {
		dashboardService.deleteLanguage(language.getId());
		return "redirect:/languages";
	}

	// Update for Category
	@PostMapping(value = "/language/update/{id}")
	public String updateType(@ModelAttribute Language language, Model model) {
		if(language.getLANGUAGE().isEmpty()) {
			model.addAttribute("NotLanguage", "Language values is not empty.");
			model.addAttribute("languages",dashboardService.getAllLanguages());
			return "languagedetails";
		}
		if(language.getLANGUAGE().length() != 2) {
			model.addAttribute("MinimumError","The language value you entered is 2 characters.");
			model.addAttribute("languages",dashboardService.getAllLanguages());
			return "languagedetails";
		}
		language.setLANGUAGE(language.getLANGUAGE().toUpperCase());
		dashboardService.updateLanguage(language);
		return "redirect:/languages";
	}
}
