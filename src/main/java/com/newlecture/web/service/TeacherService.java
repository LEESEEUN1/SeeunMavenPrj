package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.data.dao.LanguageDao;
import com.newlecture.web.data.dao.LectureDao;
import com.newlecture.web.data.dao.LectureLanguageDao;
import com.newlecture.web.data.dao.LecturePlatformDao;
import com.newlecture.web.data.dao.LevelDao;
import com.newlecture.web.data.dao.PlatformDao;
import com.newlecture.web.data.entity.Language;
import com.newlecture.web.data.entity.Lecture;
import com.newlecture.web.data.entity.LectureLanguage;
import com.newlecture.web.data.entity.LecturePlatform;
import com.newlecture.web.data.entity.Level;
import com.newlecture.web.data.entity.Platform;
import com.newlecture.web.model.admin.LectureModel;

public class TeacherService{

	@Autowired
	private LectureDao lectureDao;
	
	@Autowired
	private LanguageDao languageDao;
	
	@Autowired
	private PlatformDao platformDao;
	
	@Autowired
	private LevelDao levelDao;
	
	
	//@RequestMapping("/lecture")
	public LectureModel getLectureModel(
			int page, String field, String query){
		
		LectureModel model = new LectureModel();
		List<Lecture> lectures = lectureDao.getList(page, field, query);
		int size = lectureDao.getSize(field, query);
		
		//���� ���� ����� ǥ���ϱ� ���� ��
		model.setLectures(lectures);
		model.setTotalPageCount(size);		
				
		for(Lecture lec:lectures){
			//�θ� ���� ���� �۾�
			/*List<Level> level = levelDao.
			lec.setLevel(level);
			lec.setMember(member);*/
			
			
			lec.setLevel(levelDao.getLevelOfLecture(lec.getCode()));
			
			//�ڽ��� ���� ���� �۾�
			List<Language> langs = languageDao.getListOfLecture(lec.getCode());
	        lec.setLanguages(langs);
			
	        
			List<Platform> plats = platformDao.getListOfLecture(lec.getCode());
			lec.setPlatforms(plats);
		}
		
		
		
		/*model.setLectures();
		
		model.setPlatforms();
		model.setTotalRecordCount();*/
		return model;
	}
	
}
