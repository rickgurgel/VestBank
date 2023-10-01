package com.rickgurgel.VestBank.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickgurgel.VestBank.domain.Account;

@RestController
@RequestMapping(value="/accounts")
public class AccountResource {
	
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll(){
		Account ricardo = new Account("1234", "Ricardo Gurgel", 1500.00);
		Account arielton = new Account("4321", "Arielton Guanabara", 10000.00);
		List<Account> list = new ArrayList();
		list.addAll(Arrays.asList(ricardo, arielton));
		return ResponseEntity.ok().body(list);
	}
}
