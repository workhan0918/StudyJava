package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;

public class AccountDao {

	public AccountDao() {

	}
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, customerId)" + " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				if(account instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount)account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));
				}else {
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
		}finally {
			DataSourceManager.close(pstmt, con);
		}
	}catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public List<Account> findAllAccount() {
		String sql = "SELECT * FROM Account";
		List<Account> accountList = new ArrayList<Account>();
	   
		   
	try {	 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	   try {
		   con = DataSourceManager.getConnection();
		   pstmt = con.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   while(rs.next()) {
               Account a = null;
               a.setAid(rs.getLong("aid"));
               a.setAccountNum(rs.getString("accountNum"));
               a.setBalance(rs.getDouble("balance"));
               accountList.add(a);
		   }
	   }finally {
		   DataSourceManager.close(rs, pstmt, con);
	   }
	   }catch(SQLException e) {
		   e.printStackTrace();
	   	}
			return accountList;
	}
	
	/**
	 * 전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	 * @param ssn		주민번호
	 * @return
	 */
	public List<Account> findAccountByssn(String ssn) {
//		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accoutType, c.name, c.ssn, c.phone, a.regDate "
//	            + "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
//	            + "WHERE c.ssn = ?";
		
		String sql = "SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";
		   List<Account> list = new ArrayList<>();
		try {	 
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		   try {
			   con = DataSourceManager.getConnection();
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, ssn);
			   rs = pstmt.executeQuery();
			   Account account = null;
			   while(rs.next()) {
				   if(rs.getString("accountType").charAt(0) == 'S') {
					   account = new SavingsAccount();
					   ((SavingsAccount)account).setInterestRate(
							   rs.getDouble("interestRate"));
				   }else {
					   account = new CheckingAccount();
					   ((CheckingAccount)account).setOverdraftAmount(
							   rs.getDouble("overdraft"));
				   }
				   account.setAid(rs.getLong("aid"));
				   account.setAccountNum(rs.getString("accountNum"));
				   account.setBalance(rs.getDouble("balance"));
				   account.setCustomer(new Customer(rs.getString("name"),
						   rs.getString("ssn"),
						   rs.getString("phone")));
				   account.setRegDate(rs.getTime("regDate"));
				   list.add(account);
			   }
		   }finally {
			   DataSourceManager.close(rs, pstmt, con);
		   	}
		   }catch(SQLException e) {
			   e.printStackTrace();
		   	}
			return list;
	}
}
