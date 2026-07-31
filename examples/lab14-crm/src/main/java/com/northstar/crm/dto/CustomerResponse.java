package com.northstar.crm.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class CustomerResponse {
    private String customerId;
    private String fullName;
    private String email;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // TODO: factory of(...) that never exposes entity internals
    //idk what we are suppose to use in the lab it says Instant, but starter code we have always
    //used LocalDateTime, so Im sticking with LocalDateTime
    public static CustomerResponse of(String customerId, String fullName, String email,
                                         String status, LocalDateTime createdAt,
                                      LocalDateTime updatedAt) {
        CustomerResponse dto = new CustomerResponse();
        dto.customerId = customerId;
        dto.fullName = fullName;
        dto.email = email;
        dto.status = status;
        dto.createdAt = createdAt;
        dto.updatedAt = updatedAt;
        return dto;
    }

    public String getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}