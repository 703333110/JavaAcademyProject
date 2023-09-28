package com.project.banking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.entity.Customer;
import com.project.banking.entity.LoginCredentials;
import com.project.banking.entity.Transaction;
import com.project.banking.entity.TransactionResponse;
import com.project.banking.services.CustomerService;

@RestController
@RequestMapping("/cslogin")
public class CustomerController {
@Autowired
	private CustomerService cs;
	@PostMapping("/customer")
	public ResponseEntity<Customer> customerLogin(@RequestBody LoginCredentials loginCredentials){
	Customer cust=cs.login(loginCredentials);
		return ResponseEntity.status(HttpStatus.FOUND).body(cust);
	
	}
	@GetMapping("/changepassword/{custId}/{password}")
	public ResponseEntity<Customer> changePassword(@PathVariable int custId,@PathVariable String password  ){
		Customer cust=cs.setNewPassword(custId, password);
		return ResponseEntity.status(HttpStatus.OK).body(cust);
	}
	@GetMapping("/deposit/{custId}/{amt}")
	public ResponseEntity<?> deposit(@PathVariable int custId, @PathVariable int amt){
		TransactionResponse trd=cs.deposit(custId, amt);
		
		return ResponseEntity.status(HttpStatus.OK).body(trd);	
	}
@GetMapping("/withdraw/{custId}/{amt}")
public ResponseEntity<?> withdraw(@PathVariable int custId, @PathVariable int amt){
	TransactionResponse trw=cs.withdraw(custId, amt);
	return ResponseEntity.status(HttpStatus.OK).body(trw);
	
}
@GetMapping("/view/{custId}")
public ResponseEntity<?> view(@PathVariable int custId){
	List<TransactionResponse> listTr= cs.viewAll(custId);
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(listTr);
	
}
}

