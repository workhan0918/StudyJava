package com.varxyz.banking.domain;

public class SavingsAccount extends Account{
	private static final double DEFAULT_INTERSET_RATE = 0.03;
	private double interestRate; //이자율
	
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFAULT_INTERSET_RATE);
	}
	
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}

	public void withdraw(double amount) {
		if(balance - amount < 0) {
//			예외발생
			throw new InsufficientException("잔고 부족");
		}
		System.out.println("출금 전 금액:" + balance+"원");
		balance -= amount; // 부모에게서 balance 호출	
		System.out.println("SavingsAccount에 "+ amount+"원 출금 후 금액: " + balance+"원\n");
	}
}
