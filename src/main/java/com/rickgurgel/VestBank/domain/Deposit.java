package com.rickgurgel.VestBank.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Deposit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	private Double amount;
	private Account author;
	private Account newBalance;
	
	public Deposit() {
	}

	public Deposit(String id, Date date, Double amount, Account author, Account newBalance) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.author = author;
		this.newBalance = newBalance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Account getAuthor() {
		return author;
	}

	public void setAuthor(Account author) {
		this.author = author;
	}
	
	public Account getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(Account newBalance) {
		this.newBalance = newBalance;
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
		Deposit other = (Deposit) obj;
		return Objects.equals(id, other.id);
	}
}
