<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	<h2>강좌 목록 [ 1 / 3 ]</h2>
	<table>
		<c:forEach var="lec" items="${model.lectures }">
		<tr>
			<td>${lec.title }</td>
			<td>${lec.level.name }</td>
			<td>
				<input type="button" value="공개"/>
				<input type="button" value="편집"/>
				<input type="button" value="삭제"/>
			</td>
		</tr>
		<tr>
			<td>
				<!-- 강좌언어 -->
				<ul>
					<c:forEach var="lang" items="${lec.languages }">
					<li>
						${lang.name }
					</li>
					</c:forEach>
				</ul>
				<!-- 강좌플랫폼 -->
				<ul>
					<c:forEach var="plat" items="${lec.platforms }">
					<li>
						${plat.name }
					</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
		</c:forEach>
	</table>
</main>