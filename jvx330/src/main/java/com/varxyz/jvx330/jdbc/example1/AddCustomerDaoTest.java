package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;

public class AddCustomerDaoTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
		
//		addCustomer(dao);
//		addCustomer2(dao);
		addCustomer3(dao);
		
		context.close();
	}
	
	public static void addCustomer(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("jamong@java.com");
		c.setPasswd("2222");
		c.setName("자몽");
		c.setSsn("950402-1234567");
		c.setPhone("010-4567-8912");
		
		dao.addCustomer(c);
		System.out.println("--Inserted--");
	}
	
	
	public static void addCustomer2(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("apple@java.com");
		c.setPasswd("3333");
		c.setName("사과");
		c.setSsn("930211-1438597");
		c.setPhone("010-0000-2222");
		
		dao.addCustomer2(c);
		System.out.println("--Inserted--");
	}
	
	public static void addCustomer3(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("orange@java.com");
		c.setPasswd("5555");
		c.setName("오렌지");
		c.setSsn("920111-1238567");
		c.setPhone("010-0000-4444");
		
		long key = dao.addCustomer3(c);
		System.out.println("--key-- : " + key);
	}


}
