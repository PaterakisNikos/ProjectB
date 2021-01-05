package com.example.projectb.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
	
	public Account findByEmail(String email);
	
}
