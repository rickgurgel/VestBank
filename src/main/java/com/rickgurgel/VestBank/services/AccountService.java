package com.rickgurgel.VestBank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rickgurgel.VestBank.domain.Account;
import com.rickgurgel.VestBank.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repo;
	
	public List<Account> findAll(){
		return repo.findAll();
	}
}
