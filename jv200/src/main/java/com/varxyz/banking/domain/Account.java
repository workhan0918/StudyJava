package com.varxyz.banking.domain;

public class Account {
	protected String accountNum;
	protected double balance;
	
	public void deposite(double amount) {
		System.out.println("입금 전 금액:"+balance+"원");
		balance += amount;
		System.out.println(amount+"원"+" 입금을 완료했습니다.\n"+"입금 후 금액:"
		+balance+"원\n");
	}
}
