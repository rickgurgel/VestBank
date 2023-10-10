package com.rickgurgel.VestBank.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rickgurgel.VestBank.domain.Account;
import com.rickgurgel.VestBank.domain.Deposit;
import com.rickgurgel.VestBank.dto.AuthorDTO;
import com.rickgurgel.VestBank.repository.AccountRepository;
import com.rickgurgel.VestBank.repository.DepositRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private DepositRepository depositRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		accountRepository.deleteAll();
		depositRepository.deleteAll();
			
		Account ricardo = new Account(null, "Ricardo Gurgel", 1234.56);
		Account arielton = new Account(null, "Arielton Nunes", 23456.78);
		Account guanabara = new Account(null, "Guanabara Nunes", 6666.66);
		
		accountRepository.saveAll(Arrays.asList(ricardo, arielton, guanabara));
		
		Deposit deposit1 = new Deposit(null, sdf.parse("09/10/2023"), 2314.74, new AuthorDTO(ricardo));
		Deposit deposit2 = new Deposit(null, sdf.parse("09/10/2023"), 2314.74, new AuthorDTO(arielton));
		
		depositRepository.saveAll(Arrays.asList(deposit1, deposit2));
		
		ricardo.getDeposits().addAll(Arrays.asList(deposit1));
		arielton.getDeposits().addAll(Arrays.asList(deposit2));
		accountRepository.save(ricardo);
		accountRepository.save(arielton);
	}

}
