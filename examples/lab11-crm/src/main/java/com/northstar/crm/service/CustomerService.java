package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private final CustomerNotifier notifier;

    // No-arg constructor with no-op notifier
    public CustomerService() {
        this((customerId, oldStatus, newStatus) -> {});
    }

    // Constructor accepting a CustomerNotifier
    public CustomerService(CustomerNotifier notifier) {
        this.notifier = notifier;
    }

    private void validateCustomerId(String customerId) {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("customerId cannot be null or blank");
        }
    }

    public Customer addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        validateCustomerId(customer.getCustomerId());

        if (findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new IllegalStateException("Customer with customerId '" + customer.getCustomerId() + "' already exists");
        }

        customers.add(customer);
        return customer;
    }

    public Optional<Customer> findByCustomerId(String customerId) {
        return customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst();
    }

    public List<Customer> findByStatus(CustomerStatus status) {
        return customers.stream()
                .filter(c -> c.getStatus() == status)
                .toList();
    }

    public Customer updateStatus(String customerId, CustomerStatus newStatus) {
        Customer customer = findByCustomerId(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer with customerId '" + customerId + "' not found"));

        CustomerStatus oldStatus = customer.getStatus();
        customer.setStatus(newStatus);

        notifier.notifyStatusChange(customerId, oldStatus, newStatus);

        return customer;
    }

    public List<Customer> listAll() {
        return Collections.unmodifiableList(new ArrayList<>(customers));
    }
}