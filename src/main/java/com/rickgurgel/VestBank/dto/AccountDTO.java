package com.rickgurgel.VestBank.dto;

import java.io.Serializable;

import com.rickgurgel.VestBank.domain.Account;

public class AccountDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private Double balance;
	
	public AccountDTO() {
		
	}
	
	public AccountDTO(Account obj) {
		id = obj.getId();
		username = obj.getUsername();
		balance = obj.getBalance();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
