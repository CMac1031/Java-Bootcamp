package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerValidatorTest {

    private CustomerValidator validator;
    private InMemoryCustomerRepository repo;

    @BeforeEach
    void setUp() {
        repo = new InMemoryCustomerRepository();
        validator = new CustomerValidator(repo);
    }

    @Test
    void prospectToActiveAllowed() {
        assertDoesNotThrow(() ->
                validator.validateTransition(
                        CustomerStatus.PROSPECT,
                        CustomerStatus.ACTIVE,
                        "lab-request-001"
                )
        );
    }

    @Test
    void activeToProspectRejected() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> validator.validateTransition(
                        CustomerStatus.ACTIVE,
                        CustomerStatus.PROSPECT,
                        "lab-request-001"
                )
        );

        assertTrue(exception.getMessage().contains("ACTIVE -> PROSPECT"));
        assertTrue(exception.getMessage().contains("lab-request-001"));
    }

    @Test
    void duplicateIdRejected() {
        Customer original = new Customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                "555-0101",
                CustomerStatus.ACTIVE,
                LocalDateTime.now()
        );

        Customer duplicate = new Customer(
                "CUS-1001",
                "Different Customer",
                "different@example.com",
                "555-0199",
                CustomerStatus.PROSPECT,
                LocalDateTime.now()
        );

        repo.save(original);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> validator.validateNew(duplicate)
        );

        assertTrue(exception.getMessage().contains("duplicate customerId"));
        assertTrue(exception.getMessage().contains("CUS-1001"));
    }
}