package com.rickgurgel.VestBank.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String username;
	private Double balance;
	
	public Account() {
		super();
	}

	public Account(String id, String username, Double balance) {
		super();
		this.id = id;
		this.username = username;
		this.balance = balance;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", balance=" + balance + "]";
	}	
	
}
