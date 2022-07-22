package com.varxyz.jvx330.jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.jvx330.jdbc.Customer;

// spring 방식
public class AddCustomerDao {
	//JdbcTemplate 를 쓰는방식
	//1.
	private JdbcTemplate jdbcTemplate;
	
	public AddCustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (email, passwd, name, ssn, phone)"
				+ " VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, customer.getEmail());
						pstmt.setString(2, customer.getPasswd());
						pstmt.setString(3, customer.getName());
						pstmt.setString(4, customer.getSsn());
						pstmt.setString(5, customer.getPhone());
						
						return pstmt;
			}
		});
	}
	
	// 2. 많이 쓸 방법
	
	public void addCustomer2(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (email, passwd, name, ssn, phone)"
				+ " VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(), 
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	// 3. PK를 찾아야 할때
	
	public long addCustomer3(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (email, passwd, name, ssn, phone)"
				+ " VALUES(?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"cid"});
			pstmt.setString(1, customer.getEmail());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getSsn());
			pstmt.setString(5, customer.getPhone());
			
			return pstmt;
		};
		jdbcTemplate.update(creator, keyHolder);
		return keyHolder.getKey().longValue();
	}
}
