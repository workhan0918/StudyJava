<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 회원가입 완료</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<h1>회원가입을 축하합니다</h1>
		</header>
		<ul>
			<li><span class="userId">ID : </span>${customer.userId }</li>
			<li>비밀번호 : ${customer.passwd }</li>
			<li><span class="name">이름 : </span>${customer.name }</li>
			<li>주민번호 : ${customer.ssn }</li>
			<li>휴대전화 : ${customer.phone }</li>
		</ul>
	</div>
</body>
</html>