package com.rickgurgel.VestBank.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rickgurgel.VestBank.domain.Account;
import com.rickgurgel.VestBank.repository.AccountRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		accountRepository.deleteAll();
			
		Account ricardo = new Account(null, "Ricardo Gurgel", 1234.56);
		Account arielton = new Account(null, "Arielton Nunes", 23456.78);
		Account guanabara = new Account(null, "Guanabara Nunes", 6666.66);
		
		accountRepository.saveAll(Arrays.asList(ricardo, arielton, guanabara));
		
	}

}
