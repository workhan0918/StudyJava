package com.varxyz.jvx330.di.example6;

import java.util.List;

public interface MenuItemService {

	void addMenuItem(MenuItem item);

	List<MenuItem> getAllMenuItemList();

	MenuItem getMenuItem(String string);

}
