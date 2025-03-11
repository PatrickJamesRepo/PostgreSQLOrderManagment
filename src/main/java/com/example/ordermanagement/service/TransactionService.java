package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Transaction;
import com.example.ordermanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        transaction.setTransactionDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}
