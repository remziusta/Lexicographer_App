package com.app.lexicographer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.lexicographer.dao.IWordList;
import com.app.lexicographer.exception.NotFoundWordList;
import com.app.lexicographer.model.WordList;

@Repository("wordRepository")
public class WordListJpa implements IWordList {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<WordList> getAllWord() {
		return entityManager.createQuery("from WordList", WordList.class).getResultList();
	}

	@Override
	public WordList findByIdWordList(Long Id) throws NotFoundWordList {
		return entityManager.find(WordList.class, Id);
	}

	@Transactional
	@Override
	public void create(WordList wordlist) {
		entityManager.persist(wordlist);
	}
	
	@Transactional
	@Override
	public WordList update(WordList wordList) {
		return entityManager.merge(wordList);
	}
	
	@Transactional
	@Override
	public void delete(Long Id) {
		entityManager.remove(entityManager.getReference(WordList.class, Id));
	}

}
