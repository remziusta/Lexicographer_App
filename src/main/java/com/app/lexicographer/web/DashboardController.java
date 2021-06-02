package com.app.lexicographer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.lexicographer.service.DashboardService;

@Controller
@RequestMapping("/admin")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView getDashboard() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("words", dashboardService.getAllWord());
		mav.setViewName("dashboard");
		return mav;
	}

}
