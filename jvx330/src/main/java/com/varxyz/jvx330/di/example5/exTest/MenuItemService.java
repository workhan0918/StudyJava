package com.varxyz.jvx330.di.example5.exTest;

import java.util.List;

public interface MenuItemService {
	
	void addMenuItem(String name, int price);
	
	List<MenuItem> allViewMenu();
	
	String findNameMenu(String name);
	
}
