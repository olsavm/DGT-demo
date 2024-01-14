package com.example.demo.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable String id) {
        return transactionService.getTransactionById(id).orElse(null);
    }

    @GetMapping("/{id}/fee")
    public Double getTransactionFee(@PathVariable String id) {
        return transactionService.getTransactionFee(id);
    }
}
