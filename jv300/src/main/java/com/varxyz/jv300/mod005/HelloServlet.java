package com.varxyz.jv300.mod005;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet2", urlPatterns = "/mod005/hello.do")
public class HelloServlet extends HttpServlet{
	private static final String DEFAULT_NAME = "world";
	
	public void init() {
		
	}
	//HttpServlet에서 상속받은 메소드들을 사용한다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String pageTitle = "Hello World";
		
		String name = request.getParameter("userName");
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // Writer의 수많은 자식중들 하나 byte는 스트림, char는 read, write
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3 style = 'text-align : center;+'>Hello"+ name + "</h3>");
		out.println("</body></html>");
		out.close();
	}
}
