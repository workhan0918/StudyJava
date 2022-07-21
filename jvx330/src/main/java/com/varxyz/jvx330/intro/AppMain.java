package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		String config="com/varxyz/jvx330/intro/beans.xml";
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(config);
		
		
		Hello hello = context.getBean("helloBean", Hello.class);
		System.out.println(hello.sayHello("Spring"));
		context.close();
	}
}
