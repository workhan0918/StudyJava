package com.varxyz.banking.mvc.addCustomer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.mvc.dao.BankingConfig;
import com.varxyz.banking.mvc.dao.CustomerDao;
import com.varxyz.banking.mvc.domain.Customer;

@Controller("addCustomer.addCustomerController")
public class AddCustomerController {
	
	@GetMapping("/addCustomer/add_customer")
	public String addCustomerForm() {
		return "adds/add_customer";
	}
	
	@PostMapping("/addCustomer/add_customer")
	public String addCustomer(Customer customer, Model model) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(BankingConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		
		System.out.println(customer.getUserId());
		model.addAttribute(customer);
		dao.addCustomer(customer);
		context.close();
		return "adds/add_success_customer";
	}
	
}
