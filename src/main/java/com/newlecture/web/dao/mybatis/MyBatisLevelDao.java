package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.LevelDao;
import com.newlecture.web.data.entity.Level;

public class MyBatisLevelDao implements LevelDao{

   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public List<Level> getList(int page, String field, String query) {
      // TODO Auto-generated method stub
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.getList(page, field, query);
      
   }

   @Override
   public List<Level> getList(int page) {
      // TODO Auto-generated method stub
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.getList(page, "TITLE", "");
   }
   
   @Override
   public List<Level> getList() {
      // TODO Auto-generated method stub
      
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.getList(1, "TITLE", "");
   }

   @Override
   public Level get(String code) {
      // TODO Auto-generated method stub
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      
      return levelDao.get(code);
   }

   @Override
   public int add(Level level) {
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.add(level);
   }

   @Override
   public int update(Level level) {
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.update(level);
   }

   @Override
   public int delete(String code) {
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.delete(code);
   }

@Override
public Level getLevelOfLecture(String lectureCode) {
	LevelDao levelDao;
    levelDao = sqlSession.getMapper(LevelDao.class);
    return levelDao.getLevelOfLecture(lectureCode);
}



}