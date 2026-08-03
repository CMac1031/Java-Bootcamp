package com.northstar.crm.service;

import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.exception.BusinessException;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CustomerValidatorParameterizedTest {

    private final CustomerValidator validator =
            new CustomerValidator(
                    new InMemoryCustomerRepository()
            );

    @ParameterizedTest(name = "{0} -> {1} is allowed")
    @CsvSource({
            "PROSPECT, ACTIVE",
            "PROSPECT, CLOSED",
            "ACTIVE, SUSPENDED",
            "ACTIVE, CLOSED",
            "SUSPENDED, ACTIVE",
            "SUSPENDED, CLOSED"
    })
    void legalTransitions(
            CustomerStatus from,
            CustomerStatus to) {

        assertDoesNotThrow(
                () -> validator.validateTransition(
                        from,
                        to,
                        "lab-request-001"
                )
        );
    }

    @ParameterizedTest(name = "{0} -> {1} is rejected")
    @CsvSource({
            "ACTIVE, PROSPECT",
            "CLOSED, ACTIVE",
            "CLOSED, PROSPECT",
            "PROSPECT, SUSPENDED",
            "ACTIVE, ACTIVE",
            "SUSPENDED, PROSPECT",
            "CLOSED, CLOSED"
    })
    void illegalTransitions(
            CustomerStatus from,
            CustomerStatus to) {

        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> validator.validateTransition(
                        from,
                        to,
                        "lab-request-001"
                )
        );

        assertEquals(
                "BUSINESS_CONFLICT",
                exception.getCode()
        );

        assertEquals(
                409,
                exception.getStatusHint()
        );

        assertEquals(
                "lab-request-001",
                exception.getCorrelationId()
        );

        assertTrue(
                exception.getMessage()
                        .contains(from + " -> " + to)
        );
    }
}