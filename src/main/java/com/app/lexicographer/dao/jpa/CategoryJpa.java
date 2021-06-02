package com.app.lexicographer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.lexicographer.dao.ICategory;
import com.app.lexicographer.exception.NotFoundType;
import com.app.lexicographer.model.Category;

@Repository("categoryRepository")
public class CategoryJpa implements ICategory {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Category> getAllTypes() {
		return entityManager.createQuery("from Category", Category.class).getResultList();
	}

	@Override
	public Category findByIdType(Long Id) throws NotFoundType {
		return entityManager.find(Category.class, Id);
	}

	@Transactional
	@Override
	public void create(Category category) {
		entityManager.persist(category);
	}

	@Transactional
	@Override
	public Category update(Category category) {
		return entityManager.merge(category);
	}

	@Transactional
	@Override
	public void delete(Long Id) {
		entityManager.remove(entityManager.getReference(Category.class, Id));
	}

}
