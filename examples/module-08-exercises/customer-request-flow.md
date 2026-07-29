```mermaid
sequenceDiagram
    actor Client
    participant C as CustomerController
    participant S as CustomerService
    participant R as CustomerRepository

    Client->>C: CustomerRequest
    C->>S: createCustomer(request)
    S->>S: validate + assign ID/status
    S->>R: save(Customer)
    R-->>S: saved Customer
    S-->>C: CustomerResponse
    C-->>Client: response
```

## Now
- Package names and stub responsibilities
- Plain Java types that compile
- Documented flow

## Later
- Spring controller annotations
- Validation annotations
- Repository implementation/JPA
- HTTP response mapping
- Correlation-ID logging
```mermaid
sequenceDiagram
    actor Client
    participant C as Controller
    participant S as Service

    Client->>C: blank name
    C->>S: createCustomer(request)
    S-->>C: validation failure
    C-->>Client: safe error response later
```


| Readiness check | Result    |
| --------------- |-----------|
| I can locate each class package | Pass      |
| I can explain controller → service → repository | Pass  |
| I distinguish DTO from entity | Pass  |
| I have not added Spring/JPA/database code | Pass  |
| I am ready to build the full Maven skeleton in Lab 8 | Pass  |
