package com.varxyz.jv300.mod010;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.varxyz.jv300.mod009.UserService2;


@WebServlet("/mod010/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService2 userService;
	
	public void init() {
		userService = new UserService2();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("userId");
		
		if(userId == null) {
			System.out.println("NotFoundLoginInfo");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		System.out.println("Go To mypage.jsp");
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}

}
