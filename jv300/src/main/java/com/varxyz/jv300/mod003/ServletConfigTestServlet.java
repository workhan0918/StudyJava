package com.varxyz.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletConfigTestServlet extends HttpServlet{
	private static final String DEFAULT_SEASONS = "Spring, Summer, Fall, Winter";
	private String[] seasons;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		String season_list = config.getInitParameter("season-list");
//		if(season_list == null) {
//			season_list = DEFAULT_SEASONS; // web.xml의 파라메터값을 불러오지 못하면 쓰겠다
//		}
//		seasons = season_list.split(", ");
//	}
	
	@Override
	public void init() throws ServletException {
		String season_list = getInitParameter("season-list");
		if(season_list == null) {
			season_list = DEFAULT_SEASONS; // web.xml의 파라메터값을 불러오지 못하면 쓰겠다
		}
		seasons = season_list.split(", ");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>ServletConfig Test</h3>");
		out.println("<ul>");
		for(String season : seasons) {
			out.println("<li>" + season + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}
}
