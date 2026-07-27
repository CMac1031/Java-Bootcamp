package com.academy.bank;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BankService {

    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createCustomer() {
        // TODO: read customerId / name / email / phone; reject duplicate IDs
        if (customerCount >= MAX_CUSTOMERS) {
            System.out.println("Customer capacity reached.");
            return;
        }

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine().trim();

        if (customerId.isBlank()) {
            System.out.println("Customer ID cannot be blank.");
            return;
        }

        if (findCustomer(customerId) != null) {
            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine().trim();

        // TODO: store new Customer; print "Customer Created Successfully."
        customers[customerCount] = new Customer(customerId, name, email, phoneNumber);
        customerCount++;
        System.out.println("Customer Created Successfully.");
    }

    public void createSavingsAccount() {
        // TODO: read existing customer, initial balance, interest rate
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Account capacity reached.");
            return;
        }
        Customer customer = readExistingCustomer();
        if (customer == null) {
            System.out.println("Customer does not exist.");
            return;
        }
        double initialBalance = readPositiveAmount("Initial Balance : ");

        double interestRate = readPositiveAmount("Interest Rate : ");


        // TODO: create SavingsAccount with nextAccountNumber++; store in accounts[]
        String accountNumber = String.valueOf(nextAccountNumber++);
        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, initialBalance, customer, interestRate);
        accounts[accountCount++] = savingsAccount;

        System.out.println("Savings Account Created Successfully.");
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance : %.2f%n", initialBalance);
        System.out.printf("Interest Rate : %.2f%%%n", interestRate);
    }

    public void createCurrentAccount() {
        // TODO: read existing customer, initial balance, transaction fee
        Customer customer = readExistingCustomer();
        if (customer == null) {
            System.out.println("Customer does not exist.");
            return;
        }
        // TODO: create CurrentAccount with nextAccountNumber++; store in accounts[]
        double initialBalance = readPositiveAmount("Initial Balance : ");
        double transactionFee = readPositiveAmount("Transaction Fee : ");

        String accountNumber = String.valueOf(nextAccountNumber++);
        CurrentAccount currentAccount = new CurrentAccount(accountNumber, initialBalance, customer, transactionFee);
        accounts[accountCount] = currentAccount;
        accountCount++;

        System.out.println("Current Account Created Successfully.");
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance : %.2f%n", initialBalance);
        System.out.printf("Transaction Fee : %.2f%n", transactionFee);

    }

    public void deposit() {
        // TODO: read existing account + amount; account.deposit; recordTransaction DEPOSIT

        Account account = readExistingAccount();
        if (account == null) {return;}
        double amount = readPositiveAmount("Deposit Amount : ");
        account.deposit(amount);
        recordTransaction(account.getAccountNumber(), amount, "DEPOSIT");
        // TODO: print updated balance
        System.out.println("Deposit Successful.");
        System.out.printf("Balance Updated : %.2f%n", account.getBalance());
    }

    public void withdraw() {
        // TODO: read existing account + amount; account.withdraw; record on success
        // TODO: for CurrentAccount, print fee + total deducted; print updated balance
        Account account = readExistingAccount();
        if (account == null) {return;}
        double amount = readPositiveAmount("Withdrawal Amount : ");
        double fee = account.calculateCharges();
        double totalDeducted = amount + fee;
        boolean successful = account.withdraw(amount);

        if (!successful) {
            System.out.println("Insufficient funds.");
            System.out.printf("Balance remains : %.2f%n", account.getBalance());
            return;
        }
        recordTransaction(account.getAccountNumber(), amount, "WITHDRAW");

        System.out.println("Withdrawal Successful.");

        if (fee > 0) {
            System.out.printf("Transaction Fee : %.2f%n", fee);
            System.out.printf("Total Deducted : %.2f%n", totalDeducted);
        }

        System.out.printf("Balance Updated : %.2f%n", account.getBalance());
    }

    public void displayAccounts() {
        // TODO: if empty print message; else loop displayAccount() for each
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("----------------------------------");
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccount();
            System.out.println("----------------------------------");
        }


    }

    public void displayCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers available.");
            return;
        }

        System.out.println("----------------------------------");
        for (int i = 0; i < customerCount; i++) {
            customers[i].display();
            System.out.println("----------------------------------");
        }
    }

    public void transferMoney() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayTransactionHistory() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayHighestBalanceCustomer() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void generateAccountSummaryReport() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }
//------HElper methods -------------------------
    private Customer readExistingCustomer() {
        if (customerCount == 0) {
            System.out.println("Create a customer first.");
            return null;
        }

        System.out.print("Customer ID : ");
        String customerId = scanner.nextLine().trim();
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
        }

        return customer;
    }

    private Account readExistingAccount() {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.print("Account Number : ");
        String accountNumber = scanner.nextLine().trim();
        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        }

        return account;
    }

    private Customer findCustomer(String customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equalsIgnoreCase(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    private void recordTransaction(String accountNumber, double amount, String type) {
        if (transactionCount >= MAX_TRANSACTIONS) {
            return;
        }

        String transactionId = "T" + nextTransactionNumber++;
        String date = LocalDate.now().toString();
        transactions[transactionCount++] = new Transaction(transactionId, amount, type, date, accountNumber);
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.println("Amount must not be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid amount. Please try again.");
            }
        }
    }
}