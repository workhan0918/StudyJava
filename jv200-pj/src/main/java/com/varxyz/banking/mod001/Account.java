package com.varxyz.banking.mod001;

/**
 * 계좌정보를 캡슐화
 * 
 * @author Administrator
 *
 */
public class Account {
	double balance;
	public Account(double initBalance) {
		balance = initBalance;
	}
	/**
	 * 현재의 잔고를 리턴한다.
	 * @return 현재 잔고
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * 전달된 입금 금액을 적립한다
	 * @param amt 입금액
	 */
	public void deposit(double amt) {
		
	}
	
	
	public void withdraw(double amt) {
		// 잔고가 부족할때
		if (balance - amt < 0) {
			
		}
	}
}
