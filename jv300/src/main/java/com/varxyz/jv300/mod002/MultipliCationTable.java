package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class MultipliCationTable extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String pageTitle = "구구단";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // Writer의 수많은 자식중들 하나 byte는 스트림, char는 read, write
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3 style = 'text-align : center;'>구구단을 외자</h3>");
		out.println("<p style = 'text-align : center;'>"+Multiple()+"</p>");
		out.println("</body></html>");
		out.close();
	}
	
	public String Multiple() {
		String s = "";
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				s += (j + "X" + i + "=" + i*j + " ");
				if(j == 9) {
					s += "<br>";
				}
			}
		}
		return s;				
	}

}
