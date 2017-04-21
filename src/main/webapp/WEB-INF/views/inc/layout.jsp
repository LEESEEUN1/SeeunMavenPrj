<%@page import="com.newlecture.web.data.mysql.MYSQLNoticeDao"%>
<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!-- <script>
  window.addEventListener("load",function(e){
	 
	 var morebutton = document.querySelector("#more-button");
	  
	  var notices = [
		 {code:"1",title:"오오오"},
		 {code:"2",title:"유유유"},
		 {code:"3",title:"요요요"}
		 ]
	 
	 morebutton.onclick = function(){
		  	
		  var template =document.querySelector("#notice-row");
		  
		  for(var i in notices){
			 var tbody = document.querySelector(".notice-table tbody");
	  
		  	var tds = template.content.querySelectorAll("td")
		  	
		  	tds[0].innerText = notices[i].code;
			tds[1].innerText = notices[i].title;
			
			var clone = document.importNode(template.content,true);
			tbody.appendChild(clone);
		  }
	 };
 });
</script> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- //<link href="../css/reset.css" type="text/css" rel="stylesheet" /> -->
<link href="/MavenPrj/resource/css/reset.css" type="text/css" rel="stylesheet" />
<link href="/MavenPrj/resource/css/customer/style.css" type="text/css" rel="stylesheet" />
</head>
<script src="../js/customer/notice.js"></script>
<body>
	<!-- -------------header--------------------->
	<!-- 헤더부분 -->
	<tiles:insertAttribute name="header" />
	<!-- --------visual ----------------------->
	<!-- 비쥬얼 부분 -->
	<tiles:insertAttribute name="visual" />
	<!-- ----------------body --------------->
	<div id="body">
		<div class="content-container clearfix">		
			<!-- 어사이드부분 -->
			<tiles:insertAttribute name="aside" />
	
			<!-- 메인부분 -->
			<tiles:insertAttribute name="main" />		
		</div>
	</div>
	<!-- --------footer -------------------->
	<!-- 푸터부분 -->
	<tiles:insertAttribute name="footer" />
</body>
</html>