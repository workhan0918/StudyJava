package com.varxyz.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.example1.DataSourceConfig;

public class AccountTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);

		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
//		addAccount(dao);
//		addAccount2(dao);
//		addAccount3(dao);
		findAccountBySsn(dao);
		findAccountByCustomerId(dao);
		
		context.close();
	}
	
	// 계좌 생성
	public static void addAccount(AccountDao dao) {
		Account a = new Account();
		
		a.setCustomerId(1001);
		a.setAccountNum("111-12-1234");
		a.setAccType("S");
		a.setBalance(1000.0);
		a.setInterestRate(0.5);
		
		dao.addAccount(a);
		System.out.println("-INSERTED-");
	}
	
	// 계좌 생성
	public static void addAccount2(AccountDao dao) {
		Account a = new Account();
		
		a.setCustomerId(1002);
		a.setAccountNum("000-01-0000");
		a.setAccType("S");
		a.setBalance(10000.0);
		a.setInterestRate(0.8);
		
		dao.addAccount(a);
		System.out.println("-INSERTED-");
	}
	
	// 계좌 생성
	public static void addAccount3(AccountDao dao) {
		Account a = new Account();
		
		a.setCustomerId(1003);
		a.setAccountNum("222-13-1534");
		a.setAccType("C");
		a.setBalance(500.0);
		a.setOverAmount(20000.0);
		
		dao.addAccount(a);
		System.out.println("-INSERTED-");
	}
	
	// 주민번호로 계좌 조회
	public static void findAccountBySsn(AccountDao dao) {
		System.out.println("findAccountBySsn");
		String ssn = "940504-1234567";
		System.out.println(dao.findAccountBySsn(ssn));
	}
	
	// customerId로 계좌 조회
	public static void findAccountByCustomerId(AccountDao dao) {
		System.out.println("\nfindAccountByCustomerId");
		long customerId = 1002;
		System.out.println(dao.findAccountsByCustomerId(customerId));
	}
}
