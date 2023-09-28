package com.project.banking.entity;

public class EditCustomer {
	private String name;
	private String address;
	private long mobileNumber;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public EditCustomer(String name, String address, long mobileNumber, String email) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public EditCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
}
