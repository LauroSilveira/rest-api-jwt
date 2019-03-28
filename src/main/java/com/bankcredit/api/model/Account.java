package com.bankcredit.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account")
public class Account implements Serializable{

	private static final long serialVersionUID = 6982139906035543506L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accountId;

	@NotNull
	@Column(name = "accountNumber")
	private String accountNumber;
	
	public Account() {

	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
