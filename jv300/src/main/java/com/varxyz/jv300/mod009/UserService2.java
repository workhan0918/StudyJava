package com.varxyz.jv300.mod009;

public class UserService2 {
	private UserDao userDao = UserDao.getInstance();
	
	private static UserService2 instance = new UserService2(); // 싱글톤
	
	public static UserService2 getInstance() {
		return instance;
	}
	
	public void addUser(User2 user2) {
		userDao.addUser(user2);
	}

}
