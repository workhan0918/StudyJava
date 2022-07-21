package com.varxyz.jvx330.di.example5.exTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuItemController {
	
	@Autowired
	private MenuItemService service;
	
	public MenuItemController() {
		System.out.println("MenuItemController 생성");
	}
	
	public void addMenu(String name, int price) {
		service.addMenuItem(name, price);
	}
	
	public List<MenuItem> allViewMenu() {
		
		return service.allViewMenu();
	}
	
	public String findNameMenu(String name) {
		return service.findNameMenu(name);
	}
	
}
