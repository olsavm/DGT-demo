package com.example.demo.transaction;

import com.example.demo.feeCalculator.FeeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        if (!transaction.getType().equals("international") && !transaction.getType().equals("national")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid Transaction type");
        }
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    public Double getTransactionFee(String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        FeeCalculator calculator = new FeeCalculator();

        if (transaction.isPresent()) {
            return calculator.getFee(transaction.get().getType());
        } else {
            return null;
        }

    }
}
