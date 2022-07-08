package com.varxyz.jv300.mod009;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static UserDao instance = new UserDao(); // 싱글톤
	
	public static UserDao getInstance() {
		return instance;
	}
	
	NamingService namingService = NamingService.getInstance();
	DataSource datasource = (DataSource)namingService.getAttribute("dataSource");
	public UserDao() {
	
	}
	
	// 유저를 추가해주는 메소드
	public void addUser(User2 user) {
		System.out.println("addUser");
		String sql = "INSERT INTO USER_TABLE (name, ssn, userId, passwd, email, addr1)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getSsn());
				pstmt.setString(3, user.getUserId());
				pstmt.setString(4, user.getPasswd());
				pstmt.setString(5, user.getEmail());
				pstmt.setString(6, user.getAddr());
				pstmt.executeUpdate();
				System.out.println("AddUser Complete!");
			}finally {
				datasource.close(pstmt, con);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	// 모든 유저를 조회하는 메소드
	public List<User2> findAllUser() {
		String sql = "SELECT * FROM USER_TABLE";
		
		List<User2> userList = new ArrayList<>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User2 u2 = new User2();
					u2.setUid(rs.getString("uid"));
					u2.setUserName(rs.getString("name"));
					u2.setUserId(rs.getString("userId"));
					u2.setPasswd(rs.getString("passwd"));
					u2.setSsn(rs.getString("ssn"));
					u2.setEmail(rs.getString("email"));
					u2.setAddr(rs.getString("addr1"));
					u2.setDate(rs.getString("regDate"));
					userList.add(u2);
				}
				System.out.println("SELETE COMPLETE!");
			}finally {
				datasource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return userList;
	}
	// 로그인 유효성 검사해주는 메소드
	public boolean isValidUser(String userId, String passwd) {
		String sql = "SELECT userId, passwd FROM USER_TABLE WHERE userId = ?";
		boolean result = false;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				
				String getId = null;
				String getPw = null;

				while(rs.next()) {
					getId = rs.getString("userId");
					getPw = rs.getString("passwd");
				}

				if(userId.equals(getId) && passwd.equals(getPw)) {
					result = true;
				}
			}finally {
				datasource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
