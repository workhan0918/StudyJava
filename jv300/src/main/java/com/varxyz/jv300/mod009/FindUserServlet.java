package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/find_user.do")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService2 userService = UserService2.getInstance();
		
	public void init() throws ServletException {
		super.init();
	}
	
	private static List<User2> userList;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher = null;

		userList = userService.findAllUser();
		
		System.out.println("SELECT COMPLET");

		request.setAttribute("userList", userList);
		//4. NextPage
		dispatcher = request.getRequestDispatcher("find_user.jsp");
		dispatcher.forward(request, response);
	}

}

