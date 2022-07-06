package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/add_user.do")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService2 userService = UserService2.getInstance();
		
	public void init(ServletConfig config) throws ServletException {
		super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//1. 폼 파라메터 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String ssn = request.getParameter("ssn");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
	
		
		//2. 유효성 검증 및 반환
		List<String> errorMsgs = new ArrayList<>();
		if(userId == null || userId.length() == 0) {
			errorMsgs.add("id는 필수입력 정보입니다.");
		}else if(passwd == null || passwd.length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) {
			dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher.forward(request, response);
			return;
		}
		User2 user2 = new User2();
		user2.setUserId(userId);
		user2.setPasswd(passwd);
		user2.setUserName(userName);
		user2.setSsn(ssn);
		user2.setEmail(email1 + "@" + email2);
		user2.setAddr(addr1 + " " + addr2);
		System.out.println(user2.getUserName());
		//3. 비즈니스 서비스 호출
		System.out.println(user2.getUserName());
		userService.addUser(user2);
		request.setAttribute("user2", user2);
		//4. NextPage
		dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
	}

}

