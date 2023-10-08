package com.rickgurgel.VestBank.services;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rickgurgel.VestBank.domain.Account;
import com.rickgurgel.VestBank.dto.AccountDTO;
import com.rickgurgel.VestBank.repository.AccountRepository;
import com.rickgurgel.VestBank.services.exception.ObjectNotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repo;
	
	public List<Account> findAll(){
		return repo.findAll();
	}
	
	public Account findById(String id){
		Optional<Account> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public Account insertOneAccount(Account obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Account fromDTO(AccountDTO objDto) {
		return new Account(objDto.getId(), objDto.getUsername(), objDto.getBalance());
	}
	
}
