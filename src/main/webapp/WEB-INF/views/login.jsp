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
	<form action="login" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"/></td>  <!-- 컨트롤러에서 String id=request.getParameter("id")로 값을 가져온다 -->
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw"/></td> <!-- 컨트롤러에서 String pw=request.getParameter("pw")로 값을 가져온다 -->
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="login">
					<input type="button" value="회원가입" onclick="location.href='joinForm'"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
	var msg="${msg}";
	
	if(msg !=""){
		alert(msg);
	}
	
</script>
</html>