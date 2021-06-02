package com.app.lexicographer.dao;

import java.util.List;
import com.app.lexicographer.exception.NotFoundWordList;
import com.app.lexicographer.model.WordList;

public interface IWordList {
	List<WordList> getAllWord();
	WordList findByIdWordList(Long Id) throws NotFoundWordList;
	void create(WordList wordlist);
	WordList update(WordList wordList);
	void delete(Long Id);
}
