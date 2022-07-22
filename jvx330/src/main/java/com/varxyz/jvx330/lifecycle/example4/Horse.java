package com.varxyz.jvx330.lifecycle.example4;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

public class Horse {
	private static int count;
	
	public Horse () {
		count ++;
	}
	
	public static int getCount() {
		return count;
	}
	
	@PostConstruct // 객체가 생성된 후 호출
	public void initMenuData() {
		
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		System.out.println("Goat's final count : " + Horse.getCount());
		context.close();
	}


}
