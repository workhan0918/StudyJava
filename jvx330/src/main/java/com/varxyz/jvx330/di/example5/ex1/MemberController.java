package com.varxyz.jvx330.di.example5.ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {
	
	@Autowired
	private MemberService memberSerivce;
	
	
	public MemberController() {
		System.out.println("Bean 생성 : " + this + "By Contorller");
	}
	
	public void processRequest() {
		memberSerivce.addMember("java", "1111");
	}
}
