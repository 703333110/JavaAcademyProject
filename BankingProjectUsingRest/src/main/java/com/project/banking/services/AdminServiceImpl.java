package com.project.banking.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.banking.entity.Customer;
import com.project.banking.entity.EditCustomer;
import com.project.banking.entity.LoginCredentials;
import com.project.banking.exception.ResourceNotFoundException;
import com.project.banking.repository.BankingRepo;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired 
	private BankingRepo br;
	@Override
	public Customer RegisterCustomer(Customer customer) {
		Random random= new Random();
		long leftLimit=1L;
		long rightLimit= 1000000L;
		long accnum= (long) (leftLimit+(Math.random()*(rightLimit-leftLimit)));
		customer.setAccountNumber(accnum);
		String pswd= UUID.randomUUID().toString();
		customer.setPassword(pswd);
		LocalDate date= LocalDate.now();
		customer.setDate(date);
		LoginCredentials lc= new LoginCredentials();
		//br.save(customer);
		return br.save(customer);
	}

	@Override
	public Customer getCustomer(int custId) {
		Customer c=br.findById(custId).orElse(null);
		if(c==null) {
			throw new ResourceNotFoundException("Resource doesn't exist with given custId : "+custId);
		} else 
		return c;
	}

	@Override
	public Customer editCustomer(EditCustomer editCustomer, int custId) {
		Customer c=	br.findById(custId).orElse(null);
		if(editCustomer.getName()!=null) {
			c.setName(editCustomer.getName());
		}
		if(editCustomer.getAddress()!=null) {
			c.setAddress(editCustomer.getAddress());}
			if(editCustomer.getEmail()!=null) {
				c.setEmail(editCustomer.getEmail());
			}
			if(editCustomer.getMobileNumber()!=0) {
				c.setMobileNumber(editCustomer.getMobileNumber());
			}
		
		
		 c=br.save(c);
		return c;
	}

	@Override
	public void deleteCustomer(int custId) {
		Customer c=br.findById(custId).orElse(null);
		if(c==null) {
			throw new ResourceNotFoundException("Resource doesn't exist and no delete operation is allowed for given custId  : "+custId);
		} else 
		br.delete(c);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
				return br.findAll();
	}

}
