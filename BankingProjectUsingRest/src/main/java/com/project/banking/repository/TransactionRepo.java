package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.banking.entity.Transaction;
@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String>{

}
