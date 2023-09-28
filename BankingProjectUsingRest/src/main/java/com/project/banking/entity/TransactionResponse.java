package com.project.banking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TxnResp")
public class TransactionResponse {
	@Id
	private String transactionId;
	public TransactionResponse(String transactionId, LocalDate date, LocalTime time, int custId, String transactionType,
			int amount) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.time = time;
		this.custId = custId;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	private LocalDate date;
	private LocalTime time;
	private int custId;
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionResponse(String transactionId, LocalDate date, LocalTime time, String transactionType,
			int amount) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.time = time;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransactionResponse [transactionId=" + transactionId + ", date=" + date + ", time=" + time + ", custId="
				+ custId + ", transactionType=" + transactionType + ", amount=" + amount + "]";
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
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
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
	private String transactionType;
	private int amount;
}
