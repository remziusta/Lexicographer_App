package com.app.lexicographer.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.lexicographer.model.Category;
import com.app.lexicographer.model.Language;
import com.app.lexicographer.model.MeaningListForWord;
import com.app.lexicographer.model.Type;
import com.app.lexicographer.model.WordList;
import com.app.lexicographer.service.DashboardService;

@Controller
@RequestMapping("/words")
public class WordController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping(value = "")
	public ModelAndView getWords() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("words",dashboardService.getAllWord());
		mav.setViewName("words");
		return mav;
	}

	@GetMapping(value = "/word/details")
	public ModelAndView getCategoryDetails() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("worddetails");
		return mav;
	}

	@GetMapping(value = "/addword")
	public ModelAndView getWordAdd() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("languages", dashboardService.getAllLanguages());
		mav.addObject("categories", dashboardService.getAllCategories());
		mav.addObject("types", dashboardService.getAllTypes());
		mav.setViewName("addword");
		return mav;
	}

	@PostMapping(value = "/new")
	public String getAddNewWord(@RequestParam Map<String, String> searchParam) {
		WordList word = new WordList();
		word.setWORD(searchParam.get("WORD"));
		word.setLANGUAGE(dashboardService.findByIdLanguage(Long.valueOf(searchParam.get("wordLANGUAGE"))));
		dashboardService.createWordList(word);
		int k = 0;
		int l = 0;
		String mean = null;
		Category category = null;
		Language language = null;
		Type type;
		for (Map.Entry<String, String> entity : searchParam.entrySet()) {
			if (k > 1 && l == 0) {
				mean = entity.getValue();
				l++;
			} else if (k > 1 && l == 1) {
				language = dashboardService.findByIdLanguage(Long.valueOf(entity.getValue()));
				l++;
			} else if (k > 1 && l == 2) {
				category = dashboardService.findByIdCategory(Long.valueOf(entity.getValue()));
				l++;
			} else if (k > 1 && l == 3) {
				type = dashboardService.findByIdType(Long.valueOf(entity.getValue()));
				MeaningListForWord means = new MeaningListForWord();
				means.setWORDMEANING(mean);
				means.setCATEGORY(category);
				means.setLANGUAGE(language);
				means.setTYPE(type);
				means.setWordList(word);
				word.getMeanings().add(means);
				dashboardService.createMeaning(means);				
				l = 0;
			}
			k++;
		}
		return "redirect:/words";
	}
	
	@GetMapping(value = "/word/delete/{Id}")
	public String deleteWord(@PathVariable Long Id) {
		dashboardService.deleteWordList(Id);
		return "redirect:/words";
	}
	
}