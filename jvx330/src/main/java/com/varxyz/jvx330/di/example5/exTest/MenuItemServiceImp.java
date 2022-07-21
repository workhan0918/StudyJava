package com.varxyz.jvx330.di.example5.exTest;

import java.util.ArrayList;
import java.util.List;

public class MenuItemServiceImp implements MenuItemService {
	private List<MenuItem> arrMenuItem = new ArrayList<>();
	
	// 메뉴 추가
	@Override
	public void addMenuItem(String name, int price) {
		MenuItem item = new MenuItem();
		item.setName(name);
		item.setPrice(price);
		
		arrMenuItem.add(item);
		System.out.println("New Item Added!");
	}


	// 전체 조회
	@Override
	public List<MenuItem> allViewMenu() {
		return arrMenuItem;
	}

	
	// 이름으로 검색
	@Override
	public String findNameMenu(String name) {
		for (MenuItem items : arrMenuItem) {
			if (items.getName().equals(name)) {
				return items.getName() + " / price : " + items.getPrice();
			}
			
		}
		return "찾으시는 메뉴가 없습니다.";
	}
	
	
}
