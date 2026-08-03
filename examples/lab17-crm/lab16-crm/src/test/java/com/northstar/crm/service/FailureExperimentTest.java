package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import org.junit.jupiter.api.Test;
import com.northstar.crm.exception.BusinessException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FailureExperimentTest {

    @Test
    void repositoryFailureSurfacesAndPriorCustomerRemains() {
        Customer amina = customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        );

        FailingSaveRepository repository =
                new FailingSaveRepository(amina);

        CustomerValidator validator =
                new CustomerValidator(repository);

        CustomerService service =
                new DefaultCustomerService(repository, validator);

        Customer ravi = customer(
                "CUS-1002",
                "Ravi Singh",
                "ravi.singh@example.com",
                CustomerStatus.PROSPECT
        );

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> service.addCustomer(ravi)
);

        assertEquals("simulated repository failure", exception.getMessage());
        assertTrue(service.findById("CUS-1001").isPresent());
        assertTrue(service.findById("CUS-1002").isEmpty());
    }

    @Test
    void closedToActiveAndActiveToProspectAreRejected() {
        InMemoryCustomerRepository repository =
                new InMemoryCustomerRepository();

        CustomerValidator validator =
                new CustomerValidator(repository);

        assertThrows(
                BusinessException.class,
                () -> validator.validateTransition(
                        CustomerStatus.CLOSED,
                        CustomerStatus.ACTIVE,
                        "lab-request-001"
                )
        );

        assertThrows(
                BusinessException.class,
                () -> validator.validateTransition(
                        CustomerStatus.ACTIVE,
                        CustomerStatus.PROSPECT,
                        "lab-request-001"
                )
        );
    }

    @Test
    void activatingCustomerTwiceIsRejected() {
        InMemoryCustomerRepository repository =
                new InMemoryCustomerRepository();

        CustomerValidator validator =
                new CustomerValidator(repository);

        CustomerService service =
                new DefaultCustomerService(repository, validator);

        service.addCustomer(customer(
                "CUS-1002",
                "Ravi Singh",
                "ravi.singh@example.com",
                CustomerStatus.PROSPECT
        ));

        service.changeStatus(
                "CUS-1002",
                CustomerStatus.ACTIVE,
                "lab-request-001"
        );

        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> service.changeStatus(
                        "CUS-1002",
                        CustomerStatus.ACTIVE,
                        "lab-request-001"
                )
        );

        assertTrue(exception.getMessage().contains("ACTIVE -> ACTIVE"));
        assertEquals("lab-request-001", exception.getCorrelationId());

        assertEquals(
                CustomerStatus.ACTIVE,
                service.findById("CUS-1002").orElseThrow().getStatus()
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

    private static class FailingSaveRepository
            extends InMemoryCustomerRepository {

        FailingSaveRepository(Customer existingCustomer) {
            super.save(existingCustomer);
        }

        @Override
        public Customer save(Customer customer) {
            throw new IllegalStateException(
                    "simulated repository failure"
            );
        }
    }
}