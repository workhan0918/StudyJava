package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController") // 충돌 방지 , example3 라고 이미 경로를 정해줬기 때문에 jsp 에서 action에서 login 만 적어줘도 된다.
public class LoginController {
	
	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login"; // WebMVCConfig에서 설정해줬기 때문에 /WEB-INF/views 와 .jsp가 생략되어있다.
	}
	
//	@PostMapping("/example3/login")
	public ModelAndView login(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("userId",userId); // 서블릿에서 setattribute와 같은 기능
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result"); // 서블릿에서 request foward,response 와 같은기능 
		
		return mav;
	}
	
	// Spring식 다른방식 위에 방식보다 훨신 간편하다
	@PostMapping("/example3/login") // 파라메터 안으로 annotation이 들어올 수 도 있다. 
	public ModelAndView login(@RequestParam(value = "userId", required = true) String userId, 
							  @RequestParam String passwd) {
		
		ModelAndView mav = new ModelAndView();
	
		mav.addObject("userId",	userId); // 서블릿에서 setattribute와 같은 기능
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result"); // 서블릿에서 request foward,response 와 같은기능 
		
		return mav;
	}
}
