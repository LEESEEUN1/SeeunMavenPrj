package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.Language;

public interface LanguageDao {
	
	List<Language> getListOfLecture(String lectureCode);
	
	List<Language> getList();
	List<Language> getList(int page, String field, String query);
	List<Language> getList(int page);
	Language get(String code);
	
	int add(Language Language);
	int update(Language Language);
	int delete(String code);
	
}
