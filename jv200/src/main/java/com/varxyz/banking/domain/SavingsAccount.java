package com.varxyz.banking.domain;

public class SavingsAccount extends Account{
	private double interestRate; //이자율
	
	public void withdraw(double amount) {
		if(balance - amount < 0) {
//			예외발생
			throw new InsufficientException("잔고 부족");
		}
		System.out.println("출금 전 금액:" + balance+"원");
		balance -= amount; // 부모에게서 balance 호출	
		System.out.println("SavingsAccount에 "+ amount+"원 출금 후 금액: " + balance+"원\n");
	}

	//이자율 설정하는 메소드
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
