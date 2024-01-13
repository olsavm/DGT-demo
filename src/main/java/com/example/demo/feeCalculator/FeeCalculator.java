package com.example.demo.feeCalculator;

import org.springframework.stereotype.Service;

@Service
public class FeeCalculator {
    public double getFee(String transactionType) {
        FeeCalculationStrategy strategy;
        switch (transactionType) {
            case "international":
                strategy = new InternationalFeeStrategy();
                break;
            case "national":
                strategy = new NationalFeeStrategy();
                break;
            default:
                return 0.0;
        }
        return strategy.calculateFee();
    }
}