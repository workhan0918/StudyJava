package com.varxyz.jvx330.jdbc.example3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.example1.DataSourceConfig;

public class CustomerDaoTest {

	public static void main(String[] args) throws ParseException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		findAllCustomers(dao);
		findCustomerByRegDate(dao);
		findCustomerByEmail(dao);
		countCustomers(dao);		
		
		context.close();
	}
	// 전체조회
	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("\n[findAllCustomer()]");
		dao.findAllCustomers().forEach(c -> System.out.println(c));
	}
	// 오늘 만든 사람 날짜로 조회
	public static void findCustomerByRegDate(CustomerDao dao) {
		System.out.println("\n[findCustomerByRegDate]");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = format.parse(format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Customer> list = dao.findCustomerByRegDate(currentDate);
		for(Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	// 이메일로 조회
	public static void findCustomerByEmail(CustomerDao dao) {
		System.out.println("\n[findCustomerByEmail]");
		String email = "orange@java.com";
		System.out.println(dao.findCustomerByEmail(email));
	}
	
	// 전체 고객 갯수 조회
	public static void countCustomers(CustomerDao dao) {
		System.out.println("\n[countCustomers]");
		System.out.println(dao.countCustomers());
	}
	

}
