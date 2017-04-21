package com.newlecture.web.data.dao;
import java.util.List;

import com.newlecture.web.data.entity.Level;


public interface LevelDao {
	List<Level> getList();
	Level get(String code);
	int add(Level level);
	int update(Level level);
	int delete(String code);
	
	Level getLevelOfLecture(String lectureCode);
	
	
	List<Level> getList(int page, String field, String query);
	List<Level> getList(int page);
}
