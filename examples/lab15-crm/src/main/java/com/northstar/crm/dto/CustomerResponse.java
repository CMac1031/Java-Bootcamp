package com.northstar.crm.dto;

import java.time.LocalDateTime;

public class CustomerResponse {
    private String customerId;
    private String fullName;
    private String email;
    private String status;
    private LocalDateTime createdAt;

    public static CustomerResponse of(String customerId, String fullName, String email,
                                         String status, LocalDateTime createdAt) {
        CustomerResponse dto = new CustomerResponse();
        dto.customerId = customerId;
        dto.fullName = fullName;
        dto.email = email;
        dto.status = status;
        dto.createdAt = createdAt;
        return dto;
    }

    public String getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}