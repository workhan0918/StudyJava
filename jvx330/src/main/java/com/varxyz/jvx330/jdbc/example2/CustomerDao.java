package com.varxyz.jvx330.jdbc.example2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 전체조회
	public List<Customer> findAllCustomers() {

		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
	         public Customer mapRow(ResultSet rs, int rowNum) 
	        		 throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), 
						rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"), 
						rs.getString("phone"), rs.getDate("regDate"));
				return customer;
			}
			
		});
	}
	
	// 오늘 만든 사람 날짜로 조회
	public List<Customer> findCustomerByRegDate(Date regDate) {

		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer WHERE DATE(regDate) = ?";
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			 public Customer mapRow(ResultSet rs, int rowNum) 
	        		 throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), 
						rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"), 
						rs.getString("phone"), rs.getDate("regDate"));
				return customer;
			}
			
		}, regDate);
	}
	
	// 이메일로 조회
	public Customer findCustomerByEmail(String email) {

		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer WHERE email = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() { // queryForObject 여러개의 List를 반환해준다

			@Override
			 public Customer mapRow(ResultSet rs, int rowNum) 
	        		 throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), 
						rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"), 
						rs.getString("phone"), rs.getDate("regDate"));
				return customer;
			}
			
		}, email);
		
	}
	
	// 전체 고객 갯수 조회
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
