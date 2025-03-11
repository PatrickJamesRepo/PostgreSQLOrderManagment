package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
