package com.app.lexicographer.dao;

import java.util.List;

import com.app.lexicographer.exception.NotFoundType;
import com.app.lexicographer.model.Type;

public interface IType {
	List<Type> getAllTypes();
	Type findByIdType(Long Id) throws NotFoundType;
	void create(Type type);
	Type update(Type type);
	void delete(Long Id);
}
