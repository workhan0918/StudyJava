<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 계좌생성 완료</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<h1>계좌생성을 축하합니다</h1>
		</header>
		<ul>
			<li>유저 확인 : ${account.customer.userId }</li>
			<li>계좌 타입 : ${account.accountType }</li>
			<li>계좌 번호 : ${account.accountNum }</li>
		</ul>
	</div>
</body>
</html>