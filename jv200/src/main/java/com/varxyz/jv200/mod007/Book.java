package com.varxyz.jv200.mod007;

public class Book extends Libary{
	private int serial;
	private String name;
	// Book 생성자로 책의 시리얼번호, 이름을 받아온다.
	public Book (int serial, String name) {
		this.serial = serial;
		this.name = name;
	}
	
	public int getSerial() {
		return serial;
	}

	public String getName() {
		return name;
	}
}
