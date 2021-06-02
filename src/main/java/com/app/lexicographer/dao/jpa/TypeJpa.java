package com.app.lexicographer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.lexicographer.dao.IType;
import com.app.lexicographer.exception.NotFoundType;
import com.app.lexicographer.model.Type;

@Repository("typeRepository")
public class TypeJpa implements IType {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Type> getAllTypes() {
		return entityManager.createQuery("from Type", Type.class).getResultList();
	}

	@Override
	public Type findByIdType(Long Id) throws NotFoundType {
		return entityManager.find(Type.class, Id);
	}

	@Transactional
	@Override
	public void create(Type type) {
		entityManager.persist(type);
	}

	@Transactional
	@Override
	public Type update(Type type) {
		return entityManager.merge(type);
	}

	@Transactional
	@Override
	public void delete(Long Id) {
		entityManager.remove(entityManager.getReference(Type.class, Id));
	}

}
