package com.app.lexicographer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.lexicographer.model.User;

public class _UserDetailsService implements UserDetailsService{

	@Autowired
	private DashboardService dashboardService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= dashboardService.findByUsernameUser(username);
		user.setRole(dashboardService.findByIdRole(user.getRole().getId()));
		return new _UserDetails(user);
	}

}
