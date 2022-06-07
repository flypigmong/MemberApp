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
	<h3>회원가입 페이지</h3>
	<form action="join" method="post"> <!-- 회원가입은 노출될수있으므로 post로. -->
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="pw"/></td> <!--   어떤 패스워드넣었는지 확인하려고 text 타입으로.. -->
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="회원가입"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script></script>
</html>