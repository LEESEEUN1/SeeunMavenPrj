<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.data.mysql.MYSQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String code=request.getParameter("c");

	NoticeDao noticeDao = new MYSQLNoticeDao();
	int result = noticeDao.delete(code);
	
	if(result>0)
		response.sendRedirect("notice.jsp");

%>