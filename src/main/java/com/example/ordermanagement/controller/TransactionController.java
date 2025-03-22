package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.dto.TransactionDTO;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.Transaction;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.TransactionRepository;
import com.example.ordermanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private OrderRepository orderRepository;

    // CREATE - Create a new transaction using TransactionDTO
    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionDTO dto) {
        Transaction transaction = new Transaction();

        // Convert the orderId from DTO to Order entity
        Optional<Order> orderOptional = orderRepository.findById(dto.getOrderId());
        if (orderOptional.isPresent()) {
            transaction.setOrder(orderOptional.get());
        } else {
            throw new RuntimeException("Order not found with id: " + dto.getOrderId());
        }

        transaction.setAmount(dto.getAmount());
        transaction.setPaymentMethod(dto.getPaymentMethod());
        transaction.setStatus(dto.getStatus());

        // If a transactionDate is provided in the DTO, use it; otherwise, use the current time.
        if (dto.getTransactionDate() != null) {
            // Make sure the date string is in ISO_LOCAL_DATE_TIME format, e.g., "2025-03-22T00:00:00"
            transaction.setTransactionDate(LocalDateTime.parse(dto.getTransactionDate()));
        } else {
            transaction.setTransactionDate(LocalDateTime.now());
        }

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

    // UPDATE - Update a transaction
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTransaction) {
        return transactionRepository.findById(id).map(transaction -> {
            transaction.setAmount(updatedTransaction.getAmount());
            transaction.setPaymentMethod(updatedTransaction.getPaymentMethod());
            transaction.setStatus(updatedTransaction.getStatus());
            // Retain the original transaction date
            return transactionRepository.save(transaction);
        }).orElse(null);
    }

    // DELETE - Delete a transaction
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
    }
}
