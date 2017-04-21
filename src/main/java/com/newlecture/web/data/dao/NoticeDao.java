package com.newlecture.web.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public interface NoticeDao {
   
   String lastCode();
   
   @Select("SELECT * FROM NOTICE_VIEW   WHERE CODE=#{code}")
   NoticeView get(String code);
   
   NoticeView getPrev(String code);
   NoticeView getNext(String code);
   
   List<NoticeView> getList();
   List<NoticeView> getList(int page);
   List<NoticeView> getList(
         @Param("page") int page, 
         @Param("field") String field, 
         @Param("query") String query); 
   
   int getSize();
   int getSize(String field, String query);
   
   @SelectKey(
         statement="SELECT MAX(CAST(CODE AS UNSIGNED))+1 CODE FROM NOTICE",
         before=true,
         keyProperty="code",
         resultType=String.class)
   @Insert("INSERT INTO NOTICE( "+
         "CODE, "+
         "TITLE, "+
         "WRITER, "+
         "CONTENT "+
      ")  "+
      "VALUES( "+
      "   #{code}, "+
      "   #{title}, "+
      "   #{writer}, "+
      "   #{content} "+
      ")")
   int add(Notice notice);
   int add(String title, String content, String writer);
   
   int    update(Notice notice);
   int    update(String title, String content, String code);
   
   int delete(String code);
}




/*package com.newlecture.web.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public interface NoticeDao {
	
	String lastCode();	
	
	
	//하나의 글 가져오기
	//항목 하나를 갖고 오기 위해서 get으로 갖고 오돼, 식별할 수 있는 것이 필요
	@Select("SELECT * FROM NOTICE_VIEW WHERE CODE=#{code}")
	NoticeView get(String code);
	
	//이전글 가져오기
	NoticeView getPrev(String code);
	
	//다음글 가져오기
	NoticeView getNext(String code);
	
	List<NoticeView> getList();
	List<NoticeView> getList(int page);
	List<NoticeView> getList(
			@Param("page")int page, 
			@Param("field")String field, 
			@Param("query")String query);
	
	int getSize();
	int getSize(
			@Param("field")String field, 
			@Param("query")String query);
	
	int add(Notice notice);
	@SelectKey(statement="SELECT MAX(CAST(CODE AS UNSIGNED))+1 CODE FROM NOTICE",
			before=true,
			keyProperty="code",
			resultType=String.class)
	@Insert("INSERT INTO NOTICE(CODE,TITLE,WRITER,CONTENT)VALUES(#{code},#{title},#{writer},#{content})")
	int add(String title, String content, String writer);
	
	int update(Notice notice);
	int update(String title, String content, String code);
	
	int delete(String code);
	
	
}
*/