package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.LectureDao;
import com.newlecture.web.data.dao.LectureLanguageDao;
import com.newlecture.web.data.dao.LecturePlatformDao;
import com.newlecture.web.data.entity.Lecture;
import com.newlecture.web.data.entity.LecturePlatform;

public class MyBatisLecturePlatformDao implements LecturePlatformDao{

   @Autowired
   private SqlSession sqlSession;

   @Override
   public List<LecturePlatform> getList() {
         LecturePlatformDao lecturePlatformDao;
         lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);
         
         return lecturePlatformDao.getList();
   }
   
   @Override
   public LecturePlatform get(String platformCode, String lectureCode) {
         LecturePlatformDao lecturePlatformDao;
         lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);
         
         return lecturePlatformDao.get(platformCode, lectureCode);
   }
   
   @Override
   public int add(LecturePlatform lecturePlatForm) {
         LecturePlatformDao lecturePlatformDao;
         lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);
         
         return lecturePlatformDao.add(lecturePlatForm);
   }
   
   @Override
   public int update(LecturePlatform lecturePlatForm) {
         LecturePlatformDao lecturePlatformDao;
         lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);
         
         return lecturePlatformDao.update(lecturePlatForm);
   }
   
   @Override
   public int delete(String platformCode, String lectureCode) {
         LecturePlatformDao lecturePlatformDao;
         lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);
         
         return lecturePlatformDao.delete(platformCode, lectureCode);
   }

}