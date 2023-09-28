package com.project.banking.services;

import java.util.List;

import com.project.banking.entity.Customer;
import com.project.banking.entity.EditCustomer;

public interface AdminService {
Customer RegisterCustomer(Customer customer);
Customer getCustomer(int custId);
//Customer editCustomer(int custId);
void deleteCustomer(int custId);
List<Customer> getAllCustomer();
Customer editCustomer(EditCustomer editCustomer, int custId);
}
