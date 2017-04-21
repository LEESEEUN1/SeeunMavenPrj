package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.Lecture;


public interface LectureDao {
	List<Lecture> getList(int page, String field, String query);
	List<Lecture> getList(int page);
	List<Lecture> getList();
	Lecture get(String code);
	int getSize(String field, String query);
	int add(Lecture lecture);
	int update(Lecture lecture);
	int delete(String code);
}
