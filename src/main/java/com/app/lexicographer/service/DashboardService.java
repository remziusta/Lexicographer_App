package com.app.lexicographer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lexicographer.dao.jpa.CategoryJpa;
import com.app.lexicographer.dao.jpa.LanguageJpa;
import com.app.lexicographer.dao.jpa.MeaningJpa;
import com.app.lexicographer.dao.jpa.RoleJpa;
import com.app.lexicographer.dao.jpa.TypeJpa;
import com.app.lexicographer.dao.jpa.UserJpa;
import com.app.lexicographer.dao.jpa.WordListJpa;
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

@Service
public class DashboardService implements DashboardServiceInterface {

	TypeJpa typeRepository;

	CategoryJpa categoryRepository;

	LanguageJpa languageRepository;

	MeaningJpa meaningRepository;
	
	WordListJpa wordRepository;
	
	UserJpa userRepository;
	
	RoleJpa roleRepository;
	
	@Autowired
	public void setUserRepository(UserJpa userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setRoleRepository(RoleJpa roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Autowired
	public void setMeaningRepository(MeaningJpa meaningRepository) {
		this.meaningRepository = meaningRepository;
	}
	
	@Autowired
	public void setWordRepository(WordListJpa wordRepository) {
		this.wordRepository = wordRepository;
	}
	
	@Autowired
	public void setTypeRepository(TypeJpa typeRepository) {
		this.typeRepository = typeRepository;
	}

	@Autowired
	public void setCategoryRepository(CategoryJpa categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Autowired
	public void setLanguageRepository(LanguageJpa languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.getAllTypes();
	}

	@Override
	public Category findByIdCategory(Long Id) throws NotFoundCategory {
		return categoryRepository.findByIdType(Id);
	}

	@Override
	public void createCategory(Category category) {
		categoryRepository.create(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.update(category);
	}

	@Override
	public void deleteCategory(Long Id) {
		categoryRepository.delete(Id);
	}

	@Override
	public List<Type> getAllTypes() {
		return typeRepository.getAllTypes();
	}

	@Override
	public Type findByIdType(Long Id) throws NotFoundType {
		return typeRepository.findByIdType(Id);
	}

	@Override
	public void createType(Type type) {
		typeRepository.create(type);
	}

	@Override
	public void updateType(Type type) {
		typeRepository.update(type);
	}

	@Override
	public void deleteType(Long Id) {
			typeRepository.delete(Id);
	}

	@Override
	public List<Language> getAllLanguages() {
		return languageRepository.getAllTypes();
	}

	@Override
	public Language findByIdLanguage(Long Id) throws NotFoundLanguage {
		return languageRepository.findByIdType(Id);
	}

	@Override
	public void createLanguage(Language language) {
		languageRepository.create(language);
	}

	@Override
	public void updateLanguage(Language language) {
		languageRepository.update(language);
	}

	@Override
	public void deleteLanguage(Long Id) {
		languageRepository.delete(Id);
	}

	@Override
	public List<WordList> getAllWord() {
		return wordRepository.getAllWord();
	}

	@Override
	public WordList findByIdWordList(Long Id) throws NotFoundWordList {
		return wordRepository.findByIdWordList(Id);
	}

	@Override
	public void createWordList(WordList wordlist) {
		wordRepository.create(wordlist);
	}

	@Override
	public void updateWordList(WordList wordList) {
		wordRepository.update(wordList);
	}

	@Override
	public void deleteWordList(Long Id) {
		wordRepository.delete(Id);	
	}

	@Override
	public List<MeaningListForWord> getAllWordMeaning() {
		return meaningRepository.getAllWordMeaning();
	}

	@Override
	public MeaningListForWord findByIdMeaning(Long Id) throws NotFoundMeaining {
		return meaningRepository.findByIdMeaning(Id);
	}

	@Override
	public List<MeaningListForWord> findByIdMeaningForWordList(WordList wordlist) {
		return meaningRepository.findByIdMeaningForWordList(wordlist);
	}

	@Override
	public void createMeaning(MeaningListForWord meaningword) {
		meaningRepository.create(meaningword);
	}

	@Override
	public void updateMeaning(MeaningListForWord meaningword) {
		meaningRepository.update(meaningword);
	}

	@Override
	public void deleteMeaning(Long Id) {
		meaningRepository.delete(Id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public User findByIdUser(Long Id) throws NotFoundUser {
		return userRepository.findByIdUser(Id);
	}

	@Override
	public User findByUsernameUser(String username) throws NotFoundUser {
		return userRepository.findByUsernameUser(username);
	}

	@Override
	public void createUser(User user) {
		userRepository.create(user);		
	}

	@Override
	public void updateUser(User user) {
		userRepository.update(user);
		
	}

	@Override
	public void deleteUser(Long Id) {
		userRepository.delete(Id);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.getAllRoles();
	}

	@Override
	public Role findByIdRole(Long Id) throws NotFoundRole {
		return roleRepository.findByIdRole(Id);
	}
	
	@Override
	public Role findByRoleNameRole(String Role) throws NotFoundRole {
		return roleRepository.findByRoleNameRole(Role);
	}
	
	@Override
	public void createRole(Role role) {
		roleRepository.create(role);		
	}

	@Override
	public void updateRole(Role role) {
		roleRepository.update(role);
	}

	@Override
	public void deleteRole(Long Id) {
		roleRepository.delete(Id);		
	}

}
