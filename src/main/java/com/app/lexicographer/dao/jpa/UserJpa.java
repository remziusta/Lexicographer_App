package com.app.lexicographer.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.app.lexicographer.dao.IUser;
import com.app.lexicographer.exception.NotFoundUser;
import com.app.lexicographer.model.User;

@Repository("userRepository")
public class UserJpa implements IUser{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getAllUsers() {
		return entityManager.createQuery("from User",User.class).getResultList();
	}

	@Override
	public User findByIdUser(Long Id) throws NotFoundUser {
		return entityManager.find(User.class, Id);
	}

	@Override
	public User findByUsernameUser(String username) throws NotFoundUser {
		return entityManager.createQuery("from User where username = :username", User.class).setParameter("username", username).getSingleResult();
	}

	@Transactional
	@Override
	public void create(User user) {
		entityManager.persist(user);
		
	}
	
	@Transactional
	@Override
	public User update(User user) {
		return entityManager.merge(user);
	}
	
	@Transactional
	@Override
	public void delete(Long Id) {
		entityManager.remove(entityManager.getReference(User.class, Id));
	}
	
}
