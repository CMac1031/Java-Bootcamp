package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class CustomerService {

    private final Map<String, Customer> customersById = new LinkedHashMap<>();
    private final CustomerNotifier notifier;

    public CustomerService() {
        this((customerId, oldStatus, newStatus) -> {
            // No notification required for tests that use the default service.
        });
    }

    public CustomerService(CustomerNotifier notifier) {
        this.notifier = Objects.requireNonNull(notifier, "notifier");
    }

    public Customer createCustomer(
            String customerId,
            String fullName,
            String email,
            String phone,
            CustomerStatus status
    ) {
        Customer customer = new Customer(
                customerId,
                fullName,
                email,
                phone,
                status,
                LocalDateTime.now()
        );

        return addCustomer(customer);
    }

    public Customer addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer cannot be null");
        }

        requireNonBlank(customer.getCustomerId(), "customerId");
        requireNonBlank(customer.getFullName(), "fullName");

        if (customer.getStatus() == null) {
            throw new IllegalArgumentException("status cannot be null");
        }

        requireUniqueId(customer.getCustomerId());
        customersById.put(customer.getCustomerId(), customer);
        return customer;
    }

    public Customer getCustomer(String customerId) {
        requireNonBlank(customerId, "customerId");
        return requireExisting(customerId);
    }

    public Optional<Customer> findByCustomerId(String customerId) {
        return Optional.ofNullable(customersById.get(customerId));
    }

    public Customer updateStatus(
            String customerId,
            CustomerStatus newStatus
    ) {
        if (newStatus == null) {
            throw new IllegalArgumentException("newStatus cannot be null");
        }

        Customer customer = requireExisting(customerId);
        CustomerStatus oldStatus = customer.getStatus();

        customer.setStatus(newStatus);
        notifier.notifyStatusChange(customerId, oldStatus, newStatus);

        return customer;
    }

    public List<Customer> listAll() {
        return List.copyOf(customersById.values());
    }

    public List<Customer> findByStatus(CustomerStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("status cannot be null");
        }

        return customersById.values()
                .stream()
                .filter(customer -> customer.getStatus() == status)
                .toList();
    }

    private void requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    fieldName + " cannot be null or blank"
            );
        }
    }

    private void requireUniqueId(String customerId) {
        if (customersById.containsKey(customerId)) {
            throw new IllegalStateException(
                    "Customer ID already exists: " + customerId
            );
        }
    }

    private Customer requireExisting(String customerId) {
        Customer customer = customersById.get(customerId);

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer not found: " + customerId
            );
        }

        return customer;
    }
}