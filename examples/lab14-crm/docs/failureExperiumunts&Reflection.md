### Failure Experiment
1. Removing Hibernate Validator caused NoProviderFoundException.
   The Jakarta Validation API defines validation contracts, but Hibernate Validator
   provides the runtime implementation. I restored the dependency and the tests passed. 
2. Invalid request fields
I tested a missing fullName, invalid email, blank status, and null status.
CustomerApiFacade rejected every request with an IllegalArgumentException that
included lab-request-001. CustomerService remained empty, proving validation
occurred before addCustomer.
3. Create CUS-1001 twice
- I submitted the valid CUS-1001 Amina request twice. The first request passed
  Bean Validation and created the customer. The second request contained the same
  valid field values, so DTO validation passed again, but CustomerService rejected
  the duplicate ID with IllegalStateException. The service still contained only
  one customer.

### Reflection

Which design decision most affected correctness?
- Validating CustomerRequest at CustomerApiFacade before calling addCustomer most affected correctness. It prevents invalid data from entering the service while leaving duplicate-ID enforcement as a separate business rule.

What evidence proves the implementation works?
- The evidence that proves the implementation works includes passing all unit tests, successful validation of request fields, and proper handling of duplicate customer IDs. Additionally, the use of lab-request-001 in exception messages confirms that the correlation ID is correctly propagated through the system.
Which failure was hardest to diagnose?
- The hardest failure was reconciling the starter and extended guide’s inconsistent class names and timestamp types. CustomerResponse mixed Instant and LocalDateTime, causing compilation errors until the mapper and response factory were aligned with the actual starter classes.
