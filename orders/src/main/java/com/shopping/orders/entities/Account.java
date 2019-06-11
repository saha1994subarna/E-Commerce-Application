package com.shopping.orders.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import lombok.Data;

@Entity
@Table(name="account")
//@Data
public class Account {
	@Id
    @GeneratedValue
    @Column(name = "account_id", unique = true, nullable = false)
	private Long accountId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone")
	private Long phone;
	
	public Account() {
		
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}
