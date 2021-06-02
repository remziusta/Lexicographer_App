package com.app.lexicographer.dao;

import java.util.List;

import com.app.lexicographer.exception.NotFoundMeaining;
import com.app.lexicographer.model.MeaningListForWord;
import com.app.lexicographer.model.WordList;

public interface IMeaningListForWord {
	List<MeaningListForWord> getAllWordMeaning();
	MeaningListForWord findByIdMeaning(Long Id) throws NotFoundMeaining;
	List<MeaningListForWord> findByIdMeaningForWordList(WordList wordlist);
	void create(MeaningListForWord meaningword);
	MeaningListForWord update(MeaningListForWord meaningword);
	void delete(Long Id);
}
