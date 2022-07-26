package com.varxyz.banking.mvc.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mvc.domain.Customer;

@Repository("customerDao")
public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (userId, passwd, name, ssn, phone) "
				+ " VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(),
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
}
