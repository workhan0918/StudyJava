package com.varxyz.banking.domain;

public class BankingTest {
	public static void main(String[] args) {
		SavingsAccount savingAccount = new SavingsAccount();
		savingAccount.deposite(5000);
		savingAccount.setInterestRate(10);
		savingAccount.withdraw(1000);
		
		CheckingAccount checkingAccount = new CheckingAccount();
		checkingAccount.deposite(3000);
		checkingAccount.setOverdraftAmount(2000);
		checkingAccount.withdraw(3000);
	}
}
