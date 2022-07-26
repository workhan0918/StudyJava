<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 계좌생성</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<h1>계좌생성을 환영합니다</h1>
		</header>
		<form action="add_account" method="post" id="add_form" >
		<ul>
			<li>회원 ID : <input type="text" name="userId"> </li>
			<li>사용하실 계좌 타입을 선택해주세요.
				<select name="accountType">
					<option value='S' selected="selected">Saving Account</option>
					<option value='C'>Checked Account</option>
				</select>
			</li>
			<li>계좌번호 입력<input type=text maxlength="11" placeholder="000-00-0000" name="accountNum"></li>
		</ul>
			<input type="submit" value="계좌생성">
		</form>
	</div>
</body>
</html>