<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<style>
	#header {
		color: #08523e;
	}
	
	#content-wrapper {
		padding: 30px;
	}
	
	#footer {
		font-size: 32px;
		font-weight: bold;
	}
</style>
<body>

<div id="wrapper">
	<div id="header">
		<jsp:include page="/incl/banner.jsp">
			<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod009 : Java Beans and include<br>검색된 회원 조회.\",\"UTF-8\") %>'/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>회원 정보</h3>
			아이디 : <input type="text" value="${user.userId}" readonly><br>
			비밀번호 : <input type="text" value="${user.passwd}" readonly><br>
			이름 : <input type="text" value="${user.userName}" readonly><br>
			주민번호 앞자리 : <input type="text" value="${user.ssn}" readonly><br>
			이메일 : <input type="text" value="${user.email}" readonly><br>
			주소 : <input type="text" value="${user.addr}" readonly>
		<br>
	</div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp"%>
	</div>
</div>

</body>
</html>