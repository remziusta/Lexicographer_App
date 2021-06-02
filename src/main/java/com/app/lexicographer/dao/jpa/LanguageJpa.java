package com.app.lexicographer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.lexicographer.dao.ILanguage;
import com.app.lexicographer.exception.NotFoundType;
import com.app.lexicographer.model.Language;

@Repository("languageRepository")
public class LanguageJpa implements ILanguage {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Language> getAllTypes() {
		return entityManager.createQuery("from Language", Language.class).getResultList();
	}

	@Override
	public Language findByIdType(Long Id) throws NotFoundType {
		return entityManager.find(Language.class, Id);
	}

	@Transactional
	@Override
	public void create(Language language) {
		entityManager.persist(language);
	}

	@Transactional
	@Override
	public Language update(Language language) {
		return entityManager.merge(language);
	}

	@Transactional
	@Override
	public void delete(Long Id) {
		entityManager.remove(entityManager.getReference(Language.class, Id));
	}

}
