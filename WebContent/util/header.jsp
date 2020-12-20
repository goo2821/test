<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>My Shopping</h2>
    <br><br>
    <table>
        <tr>
            <td>
                <a href="home.jsp">home</a>
                <a href="man.jsp">남성 옷</a>
                <a href="woman.jsp">여성 옷</a>
                
                <%
                String id = (String) session.getAttribute("id");
                if(id != null){ %>
                    <%= id %>님 환영합니다.
                    <a href="logout.jsp">로그아웃</a>
                <%}else{%>
                    <a href="login.jsp">로그인</a>
                    <a href="join.jsp">회원 가입</a>
                <%} %>
            </td>
        </tr>
    </table>