<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addCustomer | PAGE</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>회원가입</h3>
	<h4>회원가입을 환영합니다.</h4>
	<form action="add_customer" method="post">
		<label>E-mail</label> : <input type="email" name="email"><br>
		<label>PW</label> : <input type="password" name="passwd"><br>
		<label>이름</label> : <input type="text" name="name"><br>
		<label>주민번호</label> : <input type="text" name="ssn"><br>
		<label>연락처</label> : <input type="tel" name="phone"><br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>