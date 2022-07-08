package com.varxyz.jv300.mod009;

import java.util.List;

public class UserService2 {
	
	private UserDao userDao = UserDao.getInstance();
	
	private static UserService2 instance = new UserService2(); // 싱글톤
	
	public static UserService2 getInstance() {
		return instance;
	}
	
	public void addUser(User2 user2) {
		userDao.addUser(user2);
	}
	
	public List<User2> findAllUser() {
		return userDao.findAllUser();
	}

	public boolean isValidUser(String userId, String passwd) {
		return userDao.isValidUser(userId, passwd);
		
	}
	
	public User2 findUserToId(String user) {
		return userDao.findUserToId(user);
	}
}
