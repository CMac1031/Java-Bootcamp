package com.northstar.crm.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler =
            new GlobalExceptionHandler();

    @Test
    void mapsNotFoundTo404() {
        ErrorResponse err = handler.fromBusiness(
                BusinessException.notFound(
                        "CUS-9999",
                        "lab-request-001"
                )
        );

        assertEquals(404, err.getStatus());
        assertEquals("CUSTOMER_NOT_FOUND", err.getError());
        assertEquals(
                "Customer not found: CUS-9999",
                err.getMessage()
        );
        assertEquals(
                "lab-request-001",
                err.getCorrelationId()
        );
        assertTrue(err.getErrors().isEmpty());
    }

    @Test
    void mapsConflictTo409() {
        ErrorResponse err = handler.fromBusiness(
                BusinessException.conflict(
                        "Illegal status transition: ACTIVE -> PROSPECT",
                        "lab-request-001"
                )
        );

        assertEquals(409, err.getStatus());
        assertEquals("BUSINESS_CONFLICT", err.getError());
        assertEquals(
                "lab-request-001",
                err.getCorrelationId()
        );
        assertTrue(err.getErrors().isEmpty());
    }

    @Test
    void unexpectedIsGeneric500() {
        Exception exception =
                new RuntimeException("secret database information");

        ErrorResponse err = handler.fromUnexpected(
                exception,
                "lab-request-001"
        );

        assertEquals(500, err.getStatus());
        assertEquals("INTERNAL_ERROR", err.getError());
        assertEquals(
                "Unexpected server error",
                err.getMessage()
        );
        assertEquals(
                "lab-request-001",
                err.getCorrelationId()
        );
        assertFalse(
                err.getMessage().contains("secret")
        );
        assertTrue(err.getErrors().isEmpty());
    }
}