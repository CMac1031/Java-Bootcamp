package com.academy.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final String transactionId;
    private final double amount;
    private final String type;
    private final String accountNumber;

    public Transaction(
            String transactionId,
            double amount,
            String type,
            String accountNumber) {

        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.accountNumber = accountNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getAccountNumber() {
        return accountmber;
    }

    public void display() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss");

        System.out.printf(
                "%s | %s | Account: %s | %s: %.2f%n",
                transactionId,
                date.format(formatter),
                accountNumber,
                type,
                amount);
    }
}