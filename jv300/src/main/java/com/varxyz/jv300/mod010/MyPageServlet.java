package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.varxyz.jv300.mod009.UserService2;


@WebServlet("/mod010/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private UserService2 userService = UserService2.getInstance();
	
	public void init() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("userId");
		
		if(userId == null) {
			System.out.println("NotFoundLoginInfo");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//쿠키 객체 생성
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue()); //쿠키 세션 ID출력
			
			if(cookie.getName().equals("lastAccessTime")) { // 마지막 접속시간 확인을 위한 로그 출력
				request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8")); //jsp에다가 이값을 출력
			}
		}
		response.addCookie(lastAccessTime());
		
		System.out.println("Go to mypage.jsp");
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}
	
	private Cookie lastAccessTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 쿠키 포맷 설정
		String dateStr = format.format(new Date());
		
		Cookie cookie = null;
		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8")); // 포맷에 -, : 이런 문자때문에 인코드를 해야함
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키를 보관하는 최대 시간 60초, 60분, 24시간, 30일
		cookie.setPath("/");
		
		return cookie;
	}

}
