package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
//		String config = "com/varxyz/jvx330/di/example3/beans.xml"; 							xml방식
//		GenericApplicationContext context = new GenericXmlApplicationContext(config);
//		MemberService memberService = context.getBean("memberService", MemberService.class);
//		System.out.println(memberService.getAllMembers());
		
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // Class 방식
		MemberService service = context.getBean("memberService", MemberService.class);
		service.getAllMembers().forEach(member -> System.out.println(member)); // 람다식
		
		/*List<Member> list = service.getAllMembers();
		  for(Member member : list) {
		  	System.out.println(member);
		  }*/
		context.close();
	}

}
