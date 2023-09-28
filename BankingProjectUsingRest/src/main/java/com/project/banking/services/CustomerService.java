package com.project.banking.services;

import java.util.List;
import java.util.Optional;

import com.project.banking.entity.*;

public interface CustomerService {
Customer setNewPassword(int custId, String password);
Customer login(LoginCredentials loginCredentials);
void logOut(int custId);
List<TransactionResponse> viewAll(int custId);
//Transaction view(int custId);
TransactionResponse withdraw(int custId, int amt);
TransactionResponse deposit(int custId, int amt);




}
