<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<style>
	#header {
		color: red;
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
			<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod007 : Java Beans and include<br>회원가입을 축하합니다.\",\"UTF-8\") %>'/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>회원가입되었습니다.</h3>
		<jsp:useBean id="user" class="com.varxyz.jv300.mod007.User" scope="request"/>
		아이디 : <jsp:getProperty property="userId" name="user"/><br>
		이름 : <jsp:getProperty property="userName" name="user"/>
	</div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp"%>
	</div>
</div>

</body>
</html>