package com.northstar.crm.dto;

import com.northstar.crm.dto.CustomerRequest;
import com.northstar.crm.dto.CustomerResponse;
import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;

public final class CustomerMapper {
    private CustomerMapper() {}

    public static Customer toEntity(CustomerRequest req) {
        // Adapt constructor args to YOUR Customer (phone, timestamps, etc.)
        return new Customer(
                req.getCustomerId(),
                req.getFullName(),
                req.getEmail(),
                null,
                CustomerStatus.valueOf(req.getStatus()),
                /* createdAt */ java.time.LocalDateTime.now()
        );
    }

    public static CustomerResponse toResponse(Customer entity) {
        return CustomerResponse.of(
                entity.getCustomerId(),
                entity.getFullName(),
                entity.getEmail(),
                entity.getStatus().name(),
                entity.getCreatedAt(),
                null
        );
    }
}