package com.varxyz.jv300.mod009;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod009/findiduser")
public class FindUserIdServlet extends HttpServlet {
	
	UserService2 userservice = UserService2.getInstance();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String getId = request.getParameter("findUser");
		
		request.setCharacterEncoding("UTF-8");
		
		User2 user = new User2();
		
		user = userservice.findUserToId(getId);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("findiduser.jsp").forward(request, response);
	}

}
