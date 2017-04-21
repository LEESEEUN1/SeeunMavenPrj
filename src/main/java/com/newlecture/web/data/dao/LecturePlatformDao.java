package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.LecturePlatform;

public interface LecturePlatformDao {
	//List<LecturePlatform> getList();
	
	
	LecturePlatform get(String platformCode, String lectureCode);
	int add(LecturePlatform lectureplatform);
	int update(LecturePlatform lectureplatform);
	int delete(String platformCode, String lectureCode);
	List<LecturePlatform> getList();
	//List<LecturePlatform> getList(int page);
}
