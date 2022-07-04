<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<style>
	h1 {
	color: red;
	}
</style>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="/incl/banner.jsp">
			<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod007 : 에러가 발생했습니다.\",\"UTF-8\") %>'/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>다음과 같은 에러가 발생했습니다..</h3>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
			</c:forEach>		
		</ul>
	</div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp"%>
	</div>
</div>
</body>
</html>