package com.project.banking.entity;
public class LoginCredentials {
	
private int custId;
private String password;
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "LoginCredentials [custId=" + custId + ", password=" + password + "]";
}

}
