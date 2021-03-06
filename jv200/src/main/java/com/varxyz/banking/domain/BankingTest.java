package com.varxyz.banking.domain;

public class BankingTest {
	public static void main(String[] args) {
		
		
		Customer c = new Customer(); //정보를 저장하기위한 Customer 객체 생성
		c.setName("한태우"); // Customer 객체에 정보들을 저장
		c.setSsn("990918");
		c.setPhone("010-1234-5678");
		c.setCustomerId("hantaewoo");
		c.setPasswd("1234");
		c.setAccount(null);
		
		CustomerService cs = new CustomerServiceImpl2(); //interface는 객체를 만들지 못하므로
		//다형성을 이용하여 객체 "구현"
		cs.addCustomer(c); // CustomerServiceTmpl에 Customer c에 담겨져있는 정보를 전달
		cs.getCustomerByssn("990918"); // CustomerServiceTmpl 안에 있는 메소드 호출
	}
}
