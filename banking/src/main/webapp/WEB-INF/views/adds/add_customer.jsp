<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 회원가입</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<h1>회원가입을 환영합니다</h1>
		</header>
		<form action="add_customer" method="post" id="add_form" >
		<ul>
			<li><span class="userid">ID : </span><input type="text" name="userId" required="required"></li>
			<li>비밀번호 : <input type="password" name="passwd" required="required"></li>
			<li><span class="name">이름 : </span><input type="text" name="name" required="required"></li>
			<li>주민번호 : <input type="text" name="ssn" required="required" placeholder="990918-1234567"></li>
			<li>휴대전화 : <input type="tel" name="phone" placeholder="010-1234-5678"></li>
		</ul>
			<input type="submit" value="가입">
		</form>
	</div>
</body>
</html>