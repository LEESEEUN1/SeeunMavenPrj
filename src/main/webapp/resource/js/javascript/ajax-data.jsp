<%@page import="com.google.gson.Gson"%>
<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.data.mysql.MYSQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String _page =request.getParameter("p");
	String _field =request.getParameter("f");
	String _query =request.getParameter("q");

	int pg=1;
	String field="TITLE";
	String query="";

	if(_page!=null &&!_page.equals("")) // 값이 넘겨 진 것이 있다면 
		pg=Integer.parseInt(_page);
	
	if(_field!=null &&!_field.equals("")) // 값이 넘겨 진 것이 있다면 
		field=_field;
	
	if(_query!=null &&!_query.equals("")) // 값이 넘겨 진 것이 있다면 
		query=_query;
	
	NoticeDao noticedao= new MYSQLNoticeDao();
	List<NoticeView> list = noticedao.getList(pg, field, query);
	
	//Thread.sleep(3000);
	//thread를 만나면 3초 동안 자다가 깨라
	//3초동안 먹통이 된 상태가 됨
	//비동기방식으로 >ajex
	//비동기란? background
	
	Gson gson = new Gson();
	String json = gson.toJson(list);
	out.println(json);
%>

