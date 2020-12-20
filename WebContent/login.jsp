<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<a href="home.jsp">HOME</a>
				<a href="login.jsp">LOGIN</a>
			</td>
		</tr>
	</table>
<form action="loginprocess.jsp" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" required="required"/></td>
			<td rowspan="2"><input type="submit" value="로그인"/></td>		
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" required="required"/></td>		
		</tr>
	</table>
</form>
	
</body>
</html>