package com.northstar.crm.api;

import com.northstar.crm.dto.CustomerRequest;
import com.northstar.crm.dto.CustomerResponse;
import com.northstar.crm.dto.CustomerMapper;
import com.northstar.crm.service.CustomerService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerApiFacade {
    private final CustomerService service;
    private final Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    public CustomerApiFacade(CustomerService service) {
        this.service = service;
    }

    public CustomerResponse create(CustomerRequest request, String correlationId) {
        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            String detail = violations.stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .collect(Collectors.joining("; "));
            throw new IllegalArgumentException(
                    "validation failed [" + correlationId + "]: " + detail);
        }
        var saved = service.addCustomer(CustomerMapper.toEntity(request));
        return CustomerMapper.toResponse(saved);
    }
    public CustomerResponse getById(String customerId, String correlationId) {
        var entity = service.findByCustomerId(customerId)  // or findById — match your API
                .orElseThrow(() -> new IllegalArgumentException(
                        "customer not found [" + correlationId + "]: " + customerId));
        return CustomerMapper.toResponse(entity);
    }
}