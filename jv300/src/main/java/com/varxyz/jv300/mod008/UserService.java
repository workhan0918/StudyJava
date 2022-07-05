package com.varxyz.jv300.mod008;

public class UserService {
	
	private static UserService instance = new UserService(); // 싱글톤
	
	private UserService() {
		
	}
	
	public static UserService getInstance() {
		return instance;
	}
	
	public void addUser(User user) {
		System.out.println("userId : " + user.getUserId().toString());
		System.out.println("userPasswd : " + user.getPasswd().toString());
		System.out.println("userName : " + user.getUserName().toString());
	}
}
