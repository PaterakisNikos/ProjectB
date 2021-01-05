package com.example.projectb.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


	@Autowired
	private AccountRepository accountRepo;
	
	public List<Account> GetAccounts(){
		List<Account> accs = new ArrayList<>();
		Iterable<Account> iterable = accountRepo.findAll();
		for(Account acc:iterable) accs.add(acc);
		return accs;
	}
	
	public long CreateAccount(String email, String pass) {
		if(accountRepo.findByEmail(email)!=null) return 0;
		Account acc = new Account(email, pass);
		accountRepo.save(acc);
		return acc.getID();
	}

	public long Autheticate(String email, String password) {
		Account acc= accountRepo.findByEmail(email);
		if(acc==null) return 0;
		else if(!acc.getPassword().equals(password))return 0;
		else return acc.getID();
	}
	
}
