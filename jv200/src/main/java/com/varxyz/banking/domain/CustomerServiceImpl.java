package com.varxyz.banking.domain;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

// Map으로 처리
public class CustomerServiceImpl implements CustomerService {
	private static CustomerService service = new CustomerServiceImpl();
	private Map<String, Customer> map = new HashMap<>();
	
	private CustomerServiceImpl() {
		super();
	}
	
	public static CustomerService getInstance() {
		return service;
	}
	
	//고객추가 메소드
	@Override
	public void addCustomer(Customer customer) {
	 if(!map.containsKey(customer.getSsn())) {
	 map.put(customer.getSsn(), customer);
	 }
	}


	@Override
	// 주민번호를 받아와서 그 주민번호의 회원을 호출해주는 메소드
	public Customer getCustomerByssn(String ssn) {
		if(map.containsKey(ssn)) {
			System.out.println("-----회원 정보-----\n\n" +
			"이름 : "+map.get(ssn).getName()+"\n"+
			"주민 번호 : "+map.get(ssn).getSsn()+"\n"+
			"휴대 전화 : "+map.get(ssn).getPhone()+"\n"+
			"고객 ID : "+map.get(ssn).getCustomerId()+"\n"+
			"고객 계좌 : "+map.get(ssn).getAccount()+"\n\n-------------------\n");
			//getName을 사용하여야만 주소값안에 있는 value값이 호출됨
			return map.get(ssn);
		}
		return null;
	}

	@Override
	// 모든 고객정보를 불러오는 메소드
	public Collection<Customer> getAllCustomers() {
		return map.values();
	}

	@Override
	// 전체 고객수를 알려주는 메소드
	public int getNumOfCustomers() {
		return map.size();
	}

}
