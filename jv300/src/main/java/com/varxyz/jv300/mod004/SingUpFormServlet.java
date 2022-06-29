package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SingUpFormServlet
 */
@WebServlet("/mod004/add_user.do")
public class SingUpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String DEFAULT_ID = "Id";
//	private static final String DEFAULT_PASSWD = "Password";
//	private static final String DEFAULT_USER_NAME = "TOM";
//	private static final String DEFAULT_SSN = "850402";
//	private static final String DEFAULT_EMAIL1 = "BoyTom";
//	private static final String DEFAULT_EMAIL2 = "@gmail.com";
//	private static final String DEFAULT_CONCERNS = "Java";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String[] concerns = request.getParameterValues("concerns");
		
		String pageTitle = "SingUpComplete!";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3 style='text-align : center;'>회원 가입 완료!</h3>");
		out.println("<p style='text-align : center;'>아이디 : " + id + "</p>");
		out.println("<p style='text-align : center;'>비밀번호 : " + passwd + "</p>");
		out.println("<p style='text-align : center;'>이름 : " + name + "</p>");
		out.println("<p style='text-align : center;'>주민번호 앞자리 : " + ssn + "</p>");
		out.println("<p style='text-align : center;'>이메일 : " + email1 + email2 + "</p>");
		out.print("<p style='text-align : center;'>관심 분야 : ");
		for(String con : concerns) {
			out.print("[" + con + "] ");
		}
		out.print("</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
