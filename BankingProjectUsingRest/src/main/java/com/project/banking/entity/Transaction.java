package com.project.banking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;



@Entity

@Table(name="Transactions")
public class Transaction {
@Id
//@GeneratedValue(strategy=GenerationType.IDENTITY)
private String transactionId;
private LocalDate date;
private LocalDateTime time;
private String transactionType;
private int amount;
private double finalBalance;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="customerId")
private Customer customer;
@Transient
private int custId;

public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public LocalDateTime getTime() {
	return time;
}
public void setTime(LocalDateTime localDateTime) {
	this.time = localDateTime;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public double getFinalBalance() {
	return finalBalance;
}
public void setFinalBalance(double finalBalance) {
	this.finalBalance = finalBalance;
}
@Override
public String toString() {
	return "Transaction [transactionId=" + transactionId + ", date=" + date + ", time=" + time + ", transactionType="
			+ transactionType + ", amount=" + amount + ", finalBalance=" + finalBalance + ",  custId=" + custId + "]";
}
public Transaction(String transactionId, LocalDate date, LocalDateTime time, String transactionType, int amount,
		double finalBalance) {
	super();
	this.transactionId = transactionId;
	this.date = date;
	this.time = time;
	this.transactionType = transactionType;
	this.amount = amount;
	this.finalBalance = finalBalance;
}
public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}


}
