package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;

public class AccountService {
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	public List<Account> getAccountBySsn(String ssn) {
		return accountDao.findAccountByssn(ssn);
	}
	/**
	 * XXX-XX-XXXX 형식의 계좌번호 생성
	 * 
	 * @return
	 */
	public String getnerateAccountNum() {
		String numStr = String.valueOf((int)(Math.random() * 1000000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.subSequence(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		return sb.toString();
	}
	
	public void depositAccount(String accountNum, double amount) {
		accountDao.deposit(accountNum, amount);
	}
}
