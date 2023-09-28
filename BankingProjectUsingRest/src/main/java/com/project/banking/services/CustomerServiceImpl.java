package com.project.banking.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.banking.entity.Customer;
import com.project.banking.entity.LoginCredentials;
import com.project.banking.entity.Transaction;
import com.project.banking.entity.TransactionResponse;
import com.project.banking.exception.InsufficientBalanceException;
import com.project.banking.exception.InvalidCredentialsException;
import com.project.banking.exception.NegativeAmountException;
import com.project.banking.exception.ResourceNotFoundException;
import com.project.banking.repository.BankingRepo;

import com.project.banking.repository.TransactionRepo;
import com.project.banking.repository.TransactionResponseRepo;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private BankingRepo brp;
@Autowired
private TransactionRepo trp;
@Autowired
private TransactionResponseRepo trrp;




public TransactionRepo getTrp() {
	return trp;
}

public void setTrp(TransactionRepo trp) {
	this.trp = trp;
}

HashMap<Integer, Transaction> hm= new HashMap();
	@Override
	public Customer setNewPassword(int custId,String password) {
		Customer c = brp.findById(custId).orElse(null);
		c.setPassword(password);
		brp.save(c);
		return c;
	}

	@Override
	public Customer login(LoginCredentials loginCredentials) {
		int id=loginCredentials.getCustId();
		Customer c = brp.findById(id).orElse(null);
		if(loginCredentials.getPassword().equals(c.getPassword())){		
			return c;
		}else
		throw new InvalidCredentialsException();
	}

	@Override
	public void logOut(int custId) {
		Customer c = brp.findById(custId).orElse(null);
		System.out.println("Hello "+c.getName()+"You have logged out successfully" );
		
		
	}

	@Override
	public List<TransactionResponse> viewAll(int custId) {
		Customer c = brp.findById(custId).orElse(null);
	
		List<TransactionResponse> list= new ArrayList();
		
		list=trrp.findAll()
				.stream()
				.filter(t->t.getCustId()==custId)
				.limit(10)
				.collect(Collectors.toList());
		
	
		return 	list;  
	}
@Transactional
	@Override
	public TransactionResponse withdraw(int custId, int amt) {
		Customer c= brp.findById(custId).orElse(null);
		if(c==null) {
			throw new ResourceNotFoundException("Resource doesn't exist with given custId : "+custId);
		} if(amt<0) {
			throw new NegativeAmountException();
		}
		else if(c.getBalance()<amt) {
			throw new InsufficientBalanceException();}
		else {
		c.setBalance(c.getBalance()-amt);
	
		Transaction t= new Transaction();
		String tid= UUID.randomUUID().toString();
		t.setTransactionId(tid);
		t.setAmount(amt);
		t.setDate(LocalDate.now());
		t.setFinalBalance(c.getBalance());
		t.setTime(LocalDateTime.now());
		t.setTransactionType("Withdraw");
		t.setCustId(custId);
		t.setCustomer(c);
		brp.save(c);
		hm.put(custId, t);
		trp.save(t);
		TransactionResponse tr=new TransactionResponse();
		tr.setTransactionId(tid);
		tr.setAmount(amt);
		tr.setDate(LocalDate.now());
		tr.setTime(LocalTime.now());
		tr.setTransactionType("Withdraw");
		tr.setCustId(custId);
		trrp.save(tr);
		return tr;
		}
		
	}

	@Override
	public TransactionResponse deposit(int custId, int amt) {
		Customer c= brp.findById(custId).orElse(null);
		if(c==null) {
			throw new ResourceNotFoundException("Resource doesn't exist with given custId : "+custId);
		}
		else if(amt<0) 
			 {
					throw new NegativeAmountException();
				}
		else {
			c.setBalance(c.getBalance()+amt);
			
			Transaction t= new Transaction();
			String tid= UUID.randomUUID().toString();
			t.setTransactionId(tid);
			t.setAmount(amt);
			t.setDate(LocalDate.now());
			t.setFinalBalance(c.getBalance());
			t.setTime(LocalDateTime.now());
			t.setTransactionType("Deposit");
			t.setCustId(custId);
			t.setCustomer(c);
			hm.put(custId, t);
			
			brp.save(c);
			trp.save(t);
			TransactionResponse tr=new TransactionResponse();
			tr.setTransactionId(tid);
			tr.setAmount(amt);
			tr.setDate(LocalDate.now());
			tr.setTime(LocalTime.now());
			tr.setTransactionType("Deposit");
			tr.setCustId(custId);
			trrp.save(tr);
			return tr;
		} 
	}

	

}
