Which tests use real in-memory repo (Lab 17 style) vs mocks (Lab 18 unit)
- Lab 17 CustomerServiceTests use InMemoryCustomerRepository to test the service, validator, and repository together. Lab 18 CustomerServiceMockitoTest and CustomerServiceBddMockTest mock CustomerRepository to isolate the service.
How to choose stub (when/given) vs verify (verify/then().should)
- Use when/given to define what a mocked method should return, such as returning Ravi from findById. Use verify/then().should() to confirm that the service called the repository correctly, including proving that save() was never called.
Correlation ID expectations on exception paths
- The correlation ID lab-request-001 should remain connected to the request when a service operation fails. 
Why both styles can coexist
- Lab 17 style tests are integration-style tests that use a real in-memory repository to test the service, validator, and repository together. Lab 18 style tests are unit tests that mock the repository to isolate the service. Both styles can coexist because they serve different purposes: integration tests verify that components work together correctly, while unit tests focus on the behavior of a single component in isolation.