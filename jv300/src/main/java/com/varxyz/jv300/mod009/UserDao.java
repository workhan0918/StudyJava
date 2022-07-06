package com.varxyz.jv300.mod009;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	private static UserDao instance = new UserDao(); // 싱글톤
	
	public static UserDao getInstance() {
		return instance;
	}
	
	NamingService namingService = NamingService.getInstance();
	DataSource datasource = (DataSource)namingService.getAttribute("dataSource");
	public UserDao() {
	
	}
	
	public void addUser(User2 user) {
		System.out.println("addUser");
		String sql = "INSERT INTO USER_TABLE (name, ssn, userId, passwd, addr1)"
				+ "VALUES (?, ?, ?, ?, ?)";
		System.out.println(1);
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			System.out.println(2);
			try {
				System.out.println(3);
				con = datasource.getConnection();
				System.out.println(4);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getSsn());
				pstmt.setString(3, user.getUserId());
				pstmt.setString(4, user.getPasswd());
				pstmt.setString(5, user.getAddr());
				pstmt.executeUpdate();
			}finally {
				datasource.close(pstmt, con);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
