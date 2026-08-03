package com.northstar.crm.api;

import com.northstar.crm.dto.CustomerResponse;
import com.northstar.crm.exception.ErrorResponse;

public sealed interface ApiResult {

    record Ok(CustomerResponse body) implements ApiResult {}

    record Fail(ErrorResponse error) implements ApiResult {}
}