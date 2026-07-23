package com.academy.bank;

public abstract class Account{
    private String accountNumber;
    private double balance;
    private Customer customer;

    protected Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;

    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    protected void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Negative Balance!");
        }

        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Cannot Deposit a Negative amount!")
            return;
        }

        setBalance(getBalance() + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Cannot Withdraw a Negative amount!")
            return false;
        }
        double totalWithdrawal = amount + calculateCharges();

        if (totalWithdrawal > getBalance()) {
            return false;
        }

        setBalance(getBalance() - totalWithdrawal);
        return true;
    }
    public abstract void displayAccount();

    public double calculateCharges() {
        return 0.0;
    }

    public double calculateInterest() {
        return 0.0;
    }

    public String getAccountType() {
        return "Account";
    }
}