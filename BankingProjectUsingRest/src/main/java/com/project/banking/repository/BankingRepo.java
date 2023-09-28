package com.project.banking.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.banking.entity.Customer;
@Repository
public interface BankingRepo extends JpaRepository<Customer, Integer> {


	

}
