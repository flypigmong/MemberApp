<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	table,th,td{
		border:1px solid black;
		border-collapse:collapse;
	}
	td,th{
		padding:5px 10px;
	}
	</style>
</head>
<body>
	<h3>${sessionScope.loginId}님의 상세정보</h3>
	<form action="update" method="post"> <!-- 회원가입은 노출될수있으므로 post로. -->
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" value="${info.id}" readonly/></td> <!-- readonly:상세정보에서 아이디는 못바꾸게 -->
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="pw" value="${info.pw}"/></td> <!--   어떤 패스워드넣었는지 확인하려고 text 타입으로.. -->
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name" value="${info.name}"/></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email" value="${info.email}"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="수정하기"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script></script>
</html>