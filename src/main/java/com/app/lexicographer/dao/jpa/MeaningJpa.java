package com.app.lexicographer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.lexicographer.dao.IMeaningListForWord;
import com.app.lexicographer.exception.NotFoundMeaining;
import com.app.lexicographer.model.MeaningListForWord;
import com.app.lexicographer.model.WordList;

@Repository("meaningRepository")
public class MeaningJpa implements IMeaningListForWord {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<MeaningListForWord> getAllWordMeaning() {
		return entityManager.createQuery("from MeaningListForWord", MeaningListForWord.class).getResultList();
	}

	@Override
	public MeaningListForWord findByIdMeaning(Long Id) throws NotFoundMeaining {
		return entityManager.find(MeaningListForWord.class, Id);
	}

	@Override
	public List<MeaningListForWord> findByIdMeaningForWordList(WordList wordlist) {
		TypedQuery<MeaningListForWord> query = entityManager.createQuery("from MeaningListForWord where wordlist:wordlist",MeaningListForWord.class);
		query.setParameter("wordlist", wordlist);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void create(MeaningListForWord meaningword) {
		entityManager.persist(meaningword);
	}

	@Transactional
	@Override
	public MeaningListForWord update(MeaningListForWord meaningword) {
		return entityManager.merge(meaningword);
	}
	
	@Transactional
	@Override
	public void delete(Long Id) {
		entityManager.remove(entityManager.getReference(MeaningListForWord.class, Id));
	}

}
