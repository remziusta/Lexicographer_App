package com.app.lexicographer.dao;

import java.util.List;

import com.app.lexicographer.exception.NotFoundRole;
import com.app.lexicographer.model.Role;

public interface IRole {
	List<Role> getAllRoles();
	Role findByIdRole(Long Id) throws NotFoundRole;
	Role findByRoleNameRole(String Role) throws NotFoundRole;
	void create(Role role);
	Role update(Role role);
	void delete(Long Id);
}
