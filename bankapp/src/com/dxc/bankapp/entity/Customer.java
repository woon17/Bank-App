package com.dxc.bankapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERDB")
public class Customer {

	@Id // primary key
	@Column(name = "USERNAME ")
	private String cusUserName;

	@Column(name = "NAME")
	private String cusName;

	@Column(name = "PASSWORD")
	private String cusPassword;

	@Column(name = "BALANCE")
	private int cusBalance;

	public Customer() {

	}

	// used by customer registration
	public Customer(String cusName, String cusUserName, String cusPassword) {
		super();
		this.cusName = cusName;
		this.cusUserName = cusUserName;
		this.cusPassword = cusPassword;
	}

	// used by customer login
	public Customer(String cusUserName, String cusPassword) {
		super();
		this.cusUserName = cusUserName;
		this.cusPassword = cusPassword;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusUserName() {
		return cusUserName;
	}

	public void setCusUserName(String cusUserName) {
		this.cusUserName = cusUserName;
	}

	public String getCusPassword() {
		return cusPassword;
	}

	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}

	public int getCusBalance() {
		return cusBalance;
	}

	public void setCusBalance(int cusBalance) {
		this.cusBalance = cusBalance;
	}

	@Override
	public String toString() {
		return "Customer [cusName=" + cusName + ", cusUserName=" + cusUserName + ", cusPassword=" + cusPassword
				+ ", cusBalance=" + cusBalance + "]";
	}

}
