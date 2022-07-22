package com.varxyz.jvx330.lifecycle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;



public class Dog implements InitializingBean, DisposableBean {
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// 맨처음 시작할때 호출됨
		System.out.println("afterPropertiesSet Called");
		if(name == null) {
			System.out.println("Property name must be set");
		}else {
			System.out.println(name);
		}
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy Called");
		// 마지막 종료되기전에 호출됨
	}

	
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("Dog's final name : " + dog.getName());
		context.close();
	}
}
