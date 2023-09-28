package com.project.banking.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="Customers")
public class Customer {
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custId;
	private String address;
	private long mobileNumber;
	private String email;
	private String accountType;
	private double balance;
	private LocalDate date;
	private long AccountNumber;
	private String password;
	@OneToMany(cascade=CascadeType.ALL, targetEntity=Transaction.class)
	private Set<Transaction> transactions;
public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String showCustomer() {
		return "Customer [name=" + name + 
				 ", AccountNumber=" + AccountNumber + "]";
	}
@Override
public String toString() {
	return "Customer [name=" + name + ", custId=" + custId + ", address=" + address + ", mobileNumber=" + mobileNumber
			+ ", email=" + email + ", accountType=" + accountType + ", balance=" + balance + ", date=" + date
			+ ", AccountNumber=" + AccountNumber + ", password=" + password +  "]";
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

public Customer(String name, String address, long mobileNumber, String email, String accountType, double balance,
		LocalDate date) {
	super();
	this.name = name;
	this.address = address;
	this.mobileNumber = mobileNumber;
	this.email = email;
	this.accountType = accountType;
	this.balance = balance;
	this.date = date;
}
public Customer(String name, String address, long mobileNumber, String email, String accountType) {
	super();
	this.name = name;
	this.address = address;
	this.mobileNumber = mobileNumber;
	this.email = email;
	this.accountType = accountType;
}


}
