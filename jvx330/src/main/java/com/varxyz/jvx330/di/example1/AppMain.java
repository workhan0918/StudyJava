package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		String config="com/varxyz/jvx330/di/example1/beans.xml";
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(config);
		
		
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);

		Foo foo2 = context.getBean("foo2", Foo.class);
		System.out.println(foo2);
		context.close();
		
//		Bar bar = new Bar;  기존방식
//		Foo foo = new Foo(bar);
	}
}
