package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Transaction;
import com.example.ordermanagement.repository.TransactionRepository;
import com.example.ordermanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    // CREATE - Create a new transaction
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    // READ - Get all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // READ - Get a transaction by ID
    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    // UPDATE - Update a transaction (e.g., update status)
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTransaction) {
        return transactionRepository.findById(id).map(transaction -> {
            transaction.setAmount(updatedTransaction.getAmount());
            transaction.setPaymentMethod(updatedTransaction.getPaymentMethod());
            transaction.setStatus(updatedTransaction.getStatus());
            // Keep the original transaction date
            return transactionRepository.save(transaction);
        }).orElse(null);
    }

    // DELETE - Delete a transaction
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
    }
}
