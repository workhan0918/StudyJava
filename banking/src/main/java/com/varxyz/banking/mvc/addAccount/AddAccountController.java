package com.varxyz.banking.mvc.addAccount;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.mvc.dao.AccountDao;
import com.varxyz.banking.mvc.dao.BankingConfig;
import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.Customer;

@Controller("addAccount.addAccountControler")
public class AddAccountController {
	
	@GetMapping("/addAccount/add_account")
	public String addAccountForm() {
		return "adds/add_account";
	}
	
	@PostMapping("/addAccount/add_account")
	public String addAccount(HttpServletRequest request, Account account, Model model) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(BankingConfig.class);
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
		Customer c = new Customer();
		c.setUserId(request.getParameter("userId"));
		account.setCustomer(c);
		System.out.println(account.getAccountType());
		model.addAttribute(account);
		dao.addAccount(account);
		context.close();
		return "adds/add_success_account";
	}
}
