package com.app.lexicographer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.lexicographer.dao.IRole;
import com.app.lexicographer.exception.NotFoundRole;
import com.app.lexicographer.model.Role;

@Repository("roleRepository")
public class RoleJpa implements IRole{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Role> getAllRoles() {
		return entityManager.createQuery("from Role", Role.class).getResultList();
	}

	@Override
	public Role findByIdRole(Long Id) throws NotFoundRole {
		return entityManager.find(Role.class, Id);
	}
	
	@Transactional
	@Override
	public void create(Role role) {
		entityManager.persist(role);		
	}
	
	@Transactional
	@Override
	public Role update(Role role) {
		return entityManager.merge(role);
	}

	@Transactional
	@Override
	public void delete(Long Id) {
		entityManager.remove(entityManager.getReference(Role.class, Id));		
	}

	@Override
	public Role findByRoleNameRole(String Role) throws NotFoundRole {
		return entityManager.createQuery("from Role where role = :role", Role.class).setParameter("role", Role).getSingleResult();
	}
}
