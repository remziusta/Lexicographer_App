package com.app.lexicographer.dao;

import java.util.List;

import com.app.lexicographer.exception.NotFoundType;
import com.app.lexicographer.model.Language;

public interface ILanguage {
	List<Language> getAllTypes();
	Language findByIdType(Long Id) throws NotFoundType;
	void create(Language language);
	Language update(Language language);
	void delete(Long Id);
}
