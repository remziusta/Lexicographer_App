package com.app.lexicographer.dao;

import java.util.List;

import com.app.lexicographer.exception.NotFoundUser;
import com.app.lexicographer.model.User;

public interface IUser {
	List<User> getAllUsers();
	User findByIdUser(Long Id) throws NotFoundUser;
	User findByUsernameUser(String username) throws NotFoundUser;
	void create(User user);
	User update(User user);
	void delete(Long Id);
}
