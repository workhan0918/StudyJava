package com.varxyz.jv200.mod008;

public class MyException extends Exception {
	MyException() {
		
	}
	
	MyException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return "음수 또는 0은 입력하실 수 없습니다!";
	}
}
