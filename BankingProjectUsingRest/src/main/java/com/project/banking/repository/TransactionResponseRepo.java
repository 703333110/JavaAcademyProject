package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.banking.entity.TransactionResponse;
@Repository
public interface TransactionResponseRepo extends JpaRepository<TransactionResponse, String> {

}
