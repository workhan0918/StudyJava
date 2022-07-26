<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STEP1 | PAGE</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>약관</h3>
	<h4>약관 내용</h4>
	<form action="step2" method="post">
		<input type="checkbox" name="agree">약관동의
		<input type="submit" value="next"/>
	</form>
	
</body>
</html>