package com.varxyz.banking.domain;


public class CustomerTest {
	public static void main(String[] args) {
		Customer c = new Customer(); //정보를 저장하기위한 Customer 객체 생성
		c.setName("한태우"); // Customer 객체에 정보들을 저장
		c.setSsn("990918");
		c.setPhone("010-1234-5678");
		c.setCustomerId("hantaewoo");
		c.setPasswd("1234");
		
		Account a = new Account("123-456-789", 10000.0);
		AccountServiceImpl.getInstance().addAccount(a);
		
//		20220621 AccountServiceImpl클래스 안쪽 객체선언으로 구현 불가능 static 메소드로 바로 호출 // CustomerService c1 = new CustomerServiceImpl(); //interface는 객체를 만들지 못하므로
		//다형성을 이용하여 객체 "구현"
		
//		c1.addCustomer(c); // CustomerServiceTmpl에 Customer c에 담겨져있는 정보를 전달
//		c1.getCustomerByssn("1234"); // CustomerServiceTmpl 안에 있는 메소드 호출
		
		CustomerService c2 = new CustomerServiceImpl2();
		c2.addCustomer(c);
		c2.getCustomerByssn("990918");
		
	}
}
