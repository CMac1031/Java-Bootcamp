package com.northstar.crm.repository;

import com.northstar.crm.entity.Customer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Map must stay private — anti-leak rule for Lab 15. */
public class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<String, Customer> store = new HashMap<>();

    @Override
    public Customer save(Customer customer) {
        // TODO: put by customerId; return customer
        store.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(String customerId) {
        // TODO: Optional.ofNullable(store.get(customerId))
        return Optional.ofNullable(store.get(customerId));
    }

    @Override
    public boolean existsById(String customerId) {
        // TODO: store.containsKey
        return store.containsKey(customerId);
    }

    @Override
    public boolean existsByEmail(String email) {
        // TODO: scan values for matching email (case-insensitive OK)
        return store.values().stream().anyMatch(customer -> customer.getEmail().equalsIgnoreCase(email));
    }

    @Override
    public List<Customer> findAll() {
        // TODO: return new ArrayList<>(store.values()) — never return the Map itself
        return List.copyOf(store.values());
    }
}