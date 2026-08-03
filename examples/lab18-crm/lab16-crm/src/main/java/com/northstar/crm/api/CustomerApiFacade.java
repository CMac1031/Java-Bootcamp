package com.northstar.crm.api;

import com.northstar.crm.dto.CustomerRequest;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.exception.BusinessException;
import com.northstar.crm.exception.GlobalExceptionHandler;
import com.northstar.crm.dto.CustomerMapper;
import com.northstar.crm.service.CustomerService;
import jakarta.validation.Validator;

public class CustomerApiFacade {

    private final CustomerService service;
    private final Validator validator;
    private final GlobalExceptionHandler handler;

    public CustomerApiFacade(
            CustomerService service,
            Validator validator,
            GlobalExceptionHandler handler) {
        this.service = service;
        this.validator = validator;
        this.handler = handler;
    }

    public ApiResult create(
            CustomerRequest request,
            String correlationId) {

        requireCorrelationId(correlationId);

        var violations = validator.validate(request);

        if (!violations.isEmpty()) {
            return new ApiResult.Fail(
                    handler.fromValidation(violations, correlationId));
        }

        try {
            var saved = service.addCustomer(
                    CustomerMapper.toEntity(request));

            return new ApiResult.Ok(
                    CustomerMapper.toResponse(saved));

        } catch (BusinessException ex) {
            return new ApiResult.Fail(
                    handler.fromBusiness(ex));

        } catch (Exception ex) {
            return new ApiResult.Fail(
                    handler.fromUnexpected(ex, correlationId));
        }
    }

    public ApiResult getById(
            String customerId,
            String correlationId) {

        requireCorrelationId(correlationId);

        try {
            return service.findById(customerId)
                    .<ApiResult>map(customer ->
                            new ApiResult.Ok(
                                    CustomerMapper.toResponse(customer)))
                    .orElseThrow(() ->
                            BusinessException.notFound(
                                    customerId,
                                    correlationId));

        } catch (BusinessException ex) {
            return new ApiResult.Fail(
                    handler.fromBusiness(ex));

        } catch (Exception ex) {
            return new ApiResult.Fail(
                    handler.fromUnexpected(ex, correlationId));
        }
    }

    public ApiResult changeStatus(
            String customerId,
            CustomerStatus newStatus,
            String correlationId) {

        requireCorrelationId(correlationId);

        try {
            var updated = service.changeStatus(
                    customerId,
                    newStatus,
                    correlationId);

            return new ApiResult.Ok(
                    CustomerMapper.toResponse(updated));

        } catch (BusinessException ex) {
            return new ApiResult.Fail(
                    handler.fromBusiness(ex));

        } catch (Exception ex) {
            return new ApiResult.Fail(
                    handler.fromUnexpected(ex, correlationId));
        }
    }

    private void requireCorrelationId(String correlationId) {
        if (correlationId == null || correlationId.isBlank()) {
            throw new IllegalArgumentException(
                    "correlationId is required");
        }
    }
}