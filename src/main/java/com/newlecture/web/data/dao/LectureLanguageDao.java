package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.LectureLanguage;


public interface LectureLanguageDao {
	//List<LectureLanguage> getList();
	List<LectureLanguage> getList(String lectureCode);
	LectureLanguage get(String lectureCode, String languageCode);
	
	int add(LectureLanguage lectureLanguage);
	int update(LectureLanguage lectureLanguage);
	int delete(String lectureCode, String languageCode);
	
	//List<LectureLanguage> getList(int page);
}
