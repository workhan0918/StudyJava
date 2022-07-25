package com.varxyz.jvx340.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/example1/saySpring")  // 아무것도 안적으면 get방식
	public ModelAndView saySpring() {
		String greeting = "Hello! Spring MVC!";
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("intro/spring");
		mav.addObject("greeting", greeting); //앞에 "greeting"속성명, gretting는 속성값
		
		return mav;
	}
}
