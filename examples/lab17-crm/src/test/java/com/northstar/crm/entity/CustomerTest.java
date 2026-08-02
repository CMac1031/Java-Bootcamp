package com.northstar.crm.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class CustomerTest {

    @Test
    void testEqualityBasedOnCustomerId() {
        LocalDateTime now = LocalDateTime.now();

        // Two customers with same customerId but different other fields
        Customer customer1 = new Customer("CUS-1001", "Amina Khan", "amina@northstar.com", "+1-555-0101",
                CustomerStatus.ACTIVE, now
        );

        Customer customer2 = new Customer("CUS-1001",  // Same customerId
                "Different Name", "different@northstar.com", "+1-555-9999",
                CustomerStatus.PROSPECT,
                now.plusDays(1)
        );

        // Should be equal because customerId is the only equality key
        assertEquals(customer1, customer2, "Customers with the same customerId must be considered equal");
    }

    @Test
    void testToStringContainsCustomerId() {
        Customer ravi = new Customer(
                "CUS-1001", "Amina Khan", "amina@northstar.com", "+1-555-0101", CustomerStatus.ACTIVE, LocalDateTime.now()
        );

        String toString = ravi.toString();
        assertTrue(toString.contains("CUS-1001"));
    }
}