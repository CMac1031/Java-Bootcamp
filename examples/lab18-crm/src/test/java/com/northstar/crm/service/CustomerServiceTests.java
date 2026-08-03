package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.exception.BusinessException;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTests {

    private DefaultCustomerService service;

    @BeforeEach
    void setUp() {
        InMemoryCustomerRepository repository =
                new InMemoryCustomerRepository();

        CustomerValidator validator =
                new CustomerValidator(repository);

        service = new DefaultCustomerService(
                repository,
                validator
        );
    }

    @Test
    void addAndActivateRaviHappyPath() {
        // Arrange
        Customer amina = customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        );

        Customer ravi = customer(
                "CUS-1002",
                "Ravi Singh",
                "ravi.singh@example.com",
                CustomerStatus.PROSPECT
        );

        service.addCustomer(amina);
        service.addCustomer(ravi);

        // Act
        Customer activated = service.changeStatus(
                "CUS-1002",
                CustomerStatus.ACTIVE,
                "lab-request-001"
        );

        // Assert
        assertEquals(
                "CUS-1002",
                activated.getCustomerId()
        );

        assertEquals(
                CustomerStatus.ACTIVE,
                activated.getStatus()
        );

        assertEquals(
                CustomerStatus.ACTIVE,
                service.findById("CUS-1002")
                        .orElseThrow()
                        .getStatus()
        );

        assertEquals(
                CustomerStatus.ACTIVE,
                service.findById("CUS-1001")
                        .orElseThrow()
                        .getStatus()
        );
    }

    @Test
    void duplicateIdThrowsConflict() {
        // Arrange
        Customer amina = customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        );

        Customer duplicate = customer(
                "CUS-1001",
                "Different Customer",
                "different@example.com",
                CustomerStatus.PROSPECT
        );

        service.addCustomer(amina);

        // Act
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> service.addCustomer(duplicate)
        );

        // Assert
        assertTrue(
                exception.getMessage()
                        .contains("duplicate customerId")
        );

        assertTrue(
                exception.getMessage()
                        .contains("CUS-1001")
        );

        assertEquals(
                "Amina Khan",
                service.findById("CUS-1001")
                        .orElseThrow()
                        .getFullName()
        );
    }

    @Test
    void illegalTransitionThrowsConflict() {
        service.addCustomer(customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        ));

        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> service.changeStatus(
                        "CUS-1001",
                        CustomerStatus.PROSPECT,
                        "lab-request-001"
                )
        );

        assertEquals("BUSINESS_CONFLICT", exception.getCode());

        assertEquals(
                CustomerStatus.ACTIVE,
                service.findById("CUS-1001")
                        .orElseThrow()
                        .getStatus()
        );
    }

    @Test
    void missingCustomerThrowsNotFound() {
        // Act
        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> service.changeStatus(
                        "CUS-9999",
                        CustomerStatus.ACTIVE,
                        "lab-request-001"
                )
        );

        // Assert
        assertEquals(
                "CUSTOMER_NOT_FOUND",
                exception.getCode()
        );

        assertEquals(
                404,
                exception.getStatusHint()
        );

        assertEquals(
                "lab-request-001",
                exception.getCorrelationId()
        );

        assertTrue(
                exception.getMessage()
                        .contains("CUS-9999")
        );
    }
    @Test
    void duplicateEmailThrowsConflict() {
        // Arrange
        service.addCustomer(customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        ));

        Customer duplicateEmail = customer(
                "CUS-1003",
                "Different Customer",
                "amina.khan@example.com",
                CustomerStatus.PROSPECT
        );

        // Act
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> service.addCustomer(duplicateEmail)
        );

        // Assert
        assertTrue(
                exception.getMessage()
                        .contains("duplicate email")
        );

        assertTrue(
                exception.getMessage()
                        .contains("amina.khan@example.com")
        );

        assertTrue(
                service.findById("CUS-1003").isEmpty()
        );
    }
    @Test
    void listAllReturnsAminaAndRavi() {
        // Arrange
        service.addCustomer(customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        ));

        service.addCustomer(customer(
                "CUS-1002",
                "Ravi Singh",
                "ravi.singh@example.com",
                CustomerStatus.PROSPECT
        ));

        // Act
        var customers = service.listAll();

        // Assert
        assertEquals(2, customers.size());

        assertTrue(
                customers.stream().anyMatch(customer ->
                        customer.getCustomerId().equals("CUS-1001")
                                && customer.getStatus()
                                == CustomerStatus.ACTIVE)
        );

        assertTrue(
                customers.stream().anyMatch(customer ->
                        customer.getCustomerId().equals("CUS-1002")
                                && customer.getStatus()
                                == CustomerStatus.PROSPECT)
        );
    }

    private Customer customer(
            String customerId,
            String fullName,
            String email,
            CustomerStatus status) {

        return new Customer(
                customerId,
                fullName,
                email,
                null,
                status,
                LocalDateTime.now()
        );
    }
}