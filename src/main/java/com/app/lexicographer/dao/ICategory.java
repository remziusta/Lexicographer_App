package com.app.lexicographer.dao;

import java.util.List;

import com.app.lexicographer.exception.NotFoundType;
import com.app.lexicographer.model.Category;

public interface ICategory {
	List<Category> getAllTypes();
	Category findByIdType(Long Id) throws NotFoundType;
	void create(Category category);
	Category update(Category category);
	void delete(Long Id);
}
