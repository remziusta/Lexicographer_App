package com.app.lexicographer.service;

import java.util.List;

import com.app.lexicographer.exception.NotFoundCategory;
import com.app.lexicographer.exception.NotFoundLanguage;
import com.app.lexicographer.exception.NotFoundMeaining;
import com.app.lexicographer.exception.NotFoundRole;
import com.app.lexicographer.exception.NotFoundType;
import com.app.lexicographer.exception.NotFoundUser;
import com.app.lexicographer.exception.NotFoundWordList;
import com.app.lexicographer.model.Category;
import com.app.lexicographer.model.Language;
import com.app.lexicographer.model.MeaningListForWord;
import com.app.lexicographer.model.Role;
import com.app.lexicographer.model.Type;
import com.app.lexicographer.model.User;
import com.app.lexicographer.model.WordList;

public interface DashboardServiceInterface {
	List<Category> getAllCategories();
	Category findByIdCategory(Long Id) throws NotFoundCategory;
	void createCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Long Id);
	
	List<Type> getAllTypes();
	Type findByIdType(Long Id) throws NotFoundType;
	void createType(Type type);
	void updateType(Type type);
	void deleteType(Long Id);
	
	List<Language> getAllLanguages();
	Language findByIdLanguage(Long Id) throws NotFoundLanguage;
	void createLanguage(Language language);
	void updateLanguage(Language language);
	void deleteLanguage(Long Id);
	
	
	List<WordList> getAllWord();
	WordList findByIdWordList(Long Id) throws NotFoundWordList;
	void createWordList(WordList wordlist);
	void updateWordList(WordList wordList);
	void deleteWordList(Long Id);
	
	List<MeaningListForWord> getAllWordMeaning();
	MeaningListForWord findByIdMeaning(Long Id) throws NotFoundMeaining;
	List<MeaningListForWord> findByIdMeaningForWordList(WordList wordlist);
	void createMeaning(MeaningListForWord meaningword);
	void updateMeaning(MeaningListForWord meaningword);
	void deleteMeaning(Long Id);
	
	List<User> getAllUsers();
	User findByIdUser(Long Id) throws NotFoundUser;
	User findByUsernameUser(String username) throws NotFoundUser;
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(Long Id);
	
	List<Role> getAllRoles();
	Role findByIdRole(Long Id) throws NotFoundRole;
	Role findByRoleNameRole(String Role) throws NotFoundRole;
	void createRole(Role role);
	void updateRole(Role role);
	void deleteRole(Long Id);
}
