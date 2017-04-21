package com.newlecture.web.data.dao;
import java.util.List;


import com.newlecture.web.data.entity.Platform;

public interface PlatformDao {
	
	List<Platform> getListOfLecture(String lectureCode);
	
	
	List<Platform> getList(int page, String field, String query);
	List<Platform> getList(int page);
	
	
	List<Platform> getList();
	Platform get(String code);
	int add(Platform Platform);
	int update(Platform Platform);
	int delete(String code);
	
	
}
