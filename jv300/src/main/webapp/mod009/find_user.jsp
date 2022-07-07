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
		color: #055123;
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
			<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod009 : Java Beans and include<br>회원조회.\",\"UTF-8\") %>'/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>회원조회되었습니다.</h3>
		<p>밑에 정보들은 el커스텀 태그로 작성되었으며 user.uid같은 코드들은 User.java에 만들어놓은 String 변수 이름입니다.</p><br>
		<c:forEach var="user" items="${userList}">
			유저 uid : ${user.uid}<br>
			유저 이름 : ${user.userName}<br>
			유저 아이디 : ${user.userId}<br>
			유저 비밀번호 : ${user.passwd}<br>
			유저 주민번호 : ${user.ssn}<br>
			유저 이메일 : ${user.email}<br>
			유저 주소 : ${user.addr}<br>
			유저 생성 날짜 : ${user.date}<br>------------------------<br>
		</c:forEach>
	</div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp"%>
	</div>
</div>

</body>
</html>