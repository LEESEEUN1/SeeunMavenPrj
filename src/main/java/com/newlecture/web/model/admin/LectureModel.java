package com.newlecture.web.model.admin;

import java.util.List;

import com.newlecture.web.data.entity.Lecture;

public class LectureModel {
	//강의목록을 보여주는 페이지만을 위한 모델
	
	private List<Lecture> lectures;
	private int totalPageCount;
	
	
	public List<Lecture> getLectures() {
		return lectures;
	}
	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	
	
}
