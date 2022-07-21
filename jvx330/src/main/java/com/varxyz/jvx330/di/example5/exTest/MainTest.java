package com.varxyz.jvx330.di.example5.exTest;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/exTest/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		MenuItemController controller = context.getBean("menuItemController", MenuItemController.class);
		controller.addMenu("아메리카노", 1000);
		controller.addMenu("카페라떼", 2000);
		controller.addMenu("카페모카", 3000);
		controller.allViewMenu().forEach(menu -> 
							System.out.println("메뉴 이름 : " + menu.getName() +
												" / 메뉴 가격 : " + menu.getPrice()+"원"));
		
		System.out.println(controller.findNameMenu("카페라떼"));
		context.close();
		


	}

}
