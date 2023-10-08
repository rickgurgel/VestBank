package com.rickgurgel.VestBank.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rickgurgel.VestBank.domain.Account;
import com.rickgurgel.VestBank.domain.Deposit;
import com.rickgurgel.VestBank.domain.Withdraw;
import com.rickgurgel.VestBank.repository.AccountRepository;
import com.rickgurgel.VestBank.repository.DepositRepository;
import com.rickgurgel.VestBank.repository.WithdrawRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private DepositRepository depositRepository;
	
	@Autowired
	private WithdrawRepository withdrawRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		accountRepository.deleteAll();
		depositRepository.deleteAll();
		withdrawRepository.deleteAll();
			
		Account ricardo = new Account(null, "Ricardo Gurgel", 1234.56);
		Account arielton = new Account(null, "Arielton Nunes", 23456.78);
		Account guanabara = new Account(null, "Guanabara Nunes", 6666.66);
		
		Deposit deposit1 = new Deposit(null, sdf.parse("08/10/2023"), 975.44, guanabara);
		Withdraw withdraw1 = new Withdraw(null, sdf.parse("08/10/2023"), 975.44, arielton);
		
		accountRepository.saveAll(Arrays.asList(ricardo, arielton, guanabara));
		depositRepository.save(deposit1);
		withdrawRepository.save(withdraw1);
	}

}
