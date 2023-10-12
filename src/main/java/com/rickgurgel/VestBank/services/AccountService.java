package com.rickgurgel.VestBank.services;

import java.util.List;
import java.util.Optional;

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
	
	public Account insert(Account obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Account update(Account obj) {
		Account newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Account newObj, Account obj) {
		newObj.setUsername(obj.getUsername());
		newObj.setBalance(obj.getBalance());
	}

	public Account fromDTO(AccountDTO objDto) {
		return new Account(objDto.getId(), objDto.getUsername(), objDto.getBalance());
	}
	
	public Account deposit(String id, double amount) {
	       Account account = findById(id);
	       account.setBalance(account.getBalance() + amount);
	       return repo.save(account);
	}

	public Account withdraw(String id, double amount) {
	       Account account = findById(id);
	       if (account.getBalance() < amount) {
	    	   throw new RuntimeException("Insufficient funds");
	       }
	       account.setBalance(account.getBalance() - amount);
	       return repo.save(account);
	}
}
