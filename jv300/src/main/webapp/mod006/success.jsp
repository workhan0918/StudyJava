<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
<h1>THIS IS SUCCESS PAGE</h1>
<%
	String userName = (String)request.getAttribute("userName");
	String userId = (String)request.getAttribute("userId");
%>
<p>가입을 환영합니다 <%=userName %>(<%=userId %>)님</p>
</body>
</html>