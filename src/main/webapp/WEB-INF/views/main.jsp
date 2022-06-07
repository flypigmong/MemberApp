<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style></style>
</head>
<body>
	<div>
		${sessionScope.loginId} 님,반갑습니다. <a href="logout">로그아웃</a>
	</div>
	<h1>메인 페이지</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th><th>이름</th><th>삭제</th><th>상세보기</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="info">
		<tr>
			<td>${info.id}</td>
			<td>${info.name}</td>
			<td><a href="delete?id=${info.id}">삭제</a></td> 
			<td><a href="detail?id=${info.id}">상세보기</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
<script>
var msg="${msg}";

if(msg != ""){
	alert(msg);
}
</script>
</html>