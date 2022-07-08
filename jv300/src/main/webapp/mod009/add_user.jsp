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
			<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod009 : Java Beans and include<br>회원가입을 환영합니다.\",\"UTF-8\") %>'/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>회원가입</h3>
		<form action="add_user.do" method="post">
			아이디 : <input type="text" name="userId"><br>
			비밀번호 : <input type="password" name="passwd"><br>
			이름 : <input type="text" name="userName"><br>
			주민번호 앞자리 : <input type="text" maxlength=6 name="ssn"><br>
			이메일 : <input type="text" name="email1">
						@<select name="email2">
						<option value="naver.com" selected>naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="daum.net">daum.net</option>
						</select>
						<br>
			주소 : 		<select name="addr1">
						<option value="서울" selected>서울</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="부산">부산</option>
						</select>
						<br>
			상세 주소 :	<input type="text" name="addr2">
			<br>
			<input style='margin-top: 20px;' type="submit" value="가입">
		</form>
		<br>
		<form action="find_user.do" method="post">
			<input type="submit" value="회원 전체 조회">
		</form>
		<form action="findiduser" method="post">
			<input type="text" name="findUser">
			<input type="submit" value="ID로 회원 검색">
		</form>
	
	</div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp"%>
	</div>
</div>

</body>
</html>