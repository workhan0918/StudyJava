package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


//List로 처리
public class CustomerServiceImpl2 implements CustomerService {
	private List<Customer> customerList = new ArrayList<>();

	@Override
	public void addCustomer(Customer customer) {
		if(getCustomerByssn(customer.getSsn()) == null) {
			customerList.add(customer);
		}
		
	}

	@Override
	public Customer getCustomerByssn(String ssn) {
		for(Customer c : customerList) {
			if(ssn.equals(c.getSsn())) {
				System.out.println("-----회원 정보-----\n\n" +
			"이름 : "+c.getName()+"\n"+
			"주민 번호 : "+c.getSsn()+"\n"+
			"휴대 전화 : "+c.getPhone()+"\n"+
			"고객 ID : "+c.getCustomerId()+"\n"+
			"고객 PW : "+c.getPasswd()+"\n"+
			"고객 계좌 : "+c.getAccount()+"\n\n-------------------\n");
				//getName을 사용하여야만 주소값안에 있는 value값이 호출됨
				return c;
			}else {
				System.err.println("에러! 찾으시는 고객 정보를 찾을 수 없습니다.");
			}
		}
		return null;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		return customerList;
	}
	
	@Override
	public int getNumOfCustomers() {
		return customerList.size();
	}
}
