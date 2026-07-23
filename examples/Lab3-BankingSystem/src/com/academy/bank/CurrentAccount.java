package com.academy.bank;

public class CurrentAccount extends Account implements Printable {
    private double transactionFee;
    public CurrentAccount(String accountNumber, double balance, customer customer, double transactionFee) {

        super(accountNumber, balance, customer);
        this.transactionFee = transactionFee;
    }
    public double getTransactionFee() {
        return transactionFee;
    }
    @Override
    public double calculateCharges() {
        return transactionFee;
    }
    @Override
    public void displayAccount() {
        System.out.printf(
                "%s account%n" +
                        "Account number: %s%n" +
                        "Customer: %s%n" +
                        "Balance: %.2f%n" +
                        "Transaction fee: %.2f%n",
                getAccountType(),
                getAccountNumber(),
                getCustomer().getName(),
                getBalance(),
                transactionFee);
    }

    @Override
    public void printDetails() {
        displayAccount();
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}