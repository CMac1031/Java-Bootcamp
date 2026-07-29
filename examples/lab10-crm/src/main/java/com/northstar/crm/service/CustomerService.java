package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * In-memory service for managing Northstar CRM customers.
 * No Spring annotations — plain Java class.
 */
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    /**
     * Add a customer to the service.
     * Rejects if customerId is null/blank.
     * Rejects if a customer with the same customerId already exists.
     *
     * @param customer the customer to add
     * @return the added customer
     * @throws IllegalArgumentException if customerId is null or blank
     * @throws IllegalStateException if a customer with this customerId already exists
     */
    public Customer addCustomer(Customer customer) {
        if (customer == null || customer.getCustomerId() == null || customer.getCustomerId().isBlank()) {
            throw new IllegalArgumentException("Customer and customerId cannot be null or blank");
        }

        boolean exists = customers.stream()
                .anyMatch(c -> c.getCustomerId().equals(customer.getCustomerId()));

        if (exists) {
            throw new IllegalStateException("Customer with customerId '" + customer.getCustomerId() + "' already exists");
        }

        customers.add(customer);
        return customer;
    }

    /**
     * Find a customer by customerId.
     *
     * @param customerId the customer ID to search for
     * @return Optional containing the customer if found, empty otherwise
     */
    public Optional<Customer> findByCustomerId(String customerId) {
        return customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst();
    }

    /**
     * Find all customers with a specific status.
     *
     * @param status the status to filter by
     * @return list of customers with the specified status
     */
    public List<Customer> findByStatus(CustomerStatus status) {
        return customers.stream()
                .filter(c -> c.getStatus() == status)
                .toList();
    }

    /**
     * Update a customer's status.
     *
     * @param customerId the ID of the customer to update
     * @param newStatus the new status
     * @return the updated customer
     * @throws IllegalArgumentException if the customer does not exist
     */
    public Customer updateStatus(String customerId, CustomerStatus newStatus) {
        Customer customer = findByCustomerId(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer with customerId '" + customerId + "' not found"));

        customer.setStatus(newStatus);
        return customer;
    }

    /**
     * Get all customers as an unmodifiable list.
     *
     * @return unmodifiable copy of all customers
     */
    public List<Customer> listAll() {
        return Collections.unmodifiableList(new ArrayList<>(customers));
    }
}