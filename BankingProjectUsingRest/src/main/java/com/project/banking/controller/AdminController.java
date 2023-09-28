package com.project.banking.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.banking.entity.Customer;
import com.project.banking.entity.EditCustomer;
import com.project.banking.services.AdminService;
@RestController
@RequestMapping("/admin")
@Secured("ADMIN")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PostMapping("/register")
public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
	Customer c1=adminService.RegisterCustomer(customer);
	return ResponseEntity.status(HttpStatus.CREATED).body(c1);
}
	@GetMapping("/{custId}")
public ResponseEntity<Customer> getCustomerById(@PathVariable int custId){
	Customer c=adminService.getCustomer(custId);
	c.setPassword(null);
	c.setBalance(0);
	return ResponseEntity.status(HttpStatus.FOUND).body(c);
	
}
	@PatchMapping("/update/{custId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody EditCustomer editCustomer, @PathVariable int custId){
		//Customer customer= adminService.getCustomer(custId);
		adminService.editCustomer(editCustomer,custId);
	Customer cd=	adminService.getCustomer(custId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cd);
	}
	@DeleteMapping("/delete/{custId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable int custId){
		
		adminService.deleteCustomer(custId);
		return ResponseEntity.noContent().build();
	}
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> allCustomer= adminService.getAllCustomer();
		return ResponseEntity.ok(allCustomer);
	}
	

}
