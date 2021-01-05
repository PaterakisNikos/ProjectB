package com.example.projectb.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectb.LogForm;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public List<Account> GetAccs() {
		return accountService.GetAccounts();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/accounts")
	public long AddAccount(@RequestBody LogForm logForm){ 
		return accountService.CreateAccount(logForm.email, logForm.password);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/accounts")
	public long AutheticateAccount(@RequestBody LogForm logForm){ 
		return accountService.Autheticate(logForm.email, logForm.password);
	}
	
}
