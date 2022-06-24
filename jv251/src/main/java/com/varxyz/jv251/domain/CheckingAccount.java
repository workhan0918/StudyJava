package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientBalanceException;
import com.varxyz.jv251.exception.OverdraftException;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	public CheckingAccount() {
		super();
	}
	
	public void withdraw(double amount) { // 마이너스 통장
		if(balance < amount) {
			//잔고 부족시 overdraftAmount 금액 한도 내에서 추가 출금을 승인
			if(balance < amount) {
				System.out.println("출금 전 금액:" + balance+"원");
				double overdraftNeeded = amount - balance;
				if(overdraftAmount < overdraftNeeded) {
					throw new OverdraftException("에러 : 한도 초과", balance, overdraftNeeded); 
			}else {
				balance = overdraftAmount*-1.0;
				overdraftAmount = overdraftAmount - overdraftNeeded;
				// 예외발생
				System.err.println("현재 남은 한도: " + overdraftAmount);
				throw new InsufficientBalanceException("한도 부족");
			}
			}
		}else {
			System.out.println("출금 전 금액:" + balance+"원");
			balance = balance - amount;
			System.out.println("CheckingAccount에 "+amount+"원 출금 후 금액: " + balance+"원\n");
		}
	}
	
	public void setOverdraftAmount(double setoverdraftAmount) {
		this.overdraftAmount = setoverdraftAmount;
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}
	
}
