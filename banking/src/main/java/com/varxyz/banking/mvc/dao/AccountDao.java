package com.varxyz.banking.mvc.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mvc.domain.Account;

@Repository("accountDao")
public class AccountDao {
		private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(userId, accountNum, "
				+ " balance, interestRate, overAmount, accType) "
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		System.out.println(account.getCustomer().getUserId());
		jdbcTemplate.update(sql, account.getCustomer().getUserId(), account.getAccountNum(),
			 account.getBalance(), account.getInterestRate(), account.getOverAmount(), account.getAccountType());
	}
}
