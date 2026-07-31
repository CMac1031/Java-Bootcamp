Which inputs are untrusted (customer fields from callers)?
- All customer data received from callers is untrusted, including customerId, fullName, email, phone, and status
Where are authn/authz/validation enforced after refactor (service helpers—auth still absent)?
- Authentication and authorization are enforced in the service layer, specifically within the helper methods that validate customer data. However, authentication is still absent in this refactor, so it should be implemented in future iterations.
Which values are sensitive, and where stored (none beyond samples)?
- There are no sensitive values stored beyond sample data in this refactor. In a production environment, sensitive information such as passwords or personal data should be securely stored using appropriate encryption and access controls.
What can be retried safely (get; create is not silently idempotent)?
  - The `getCustomer` method can be retried safely, as it is a read-only operation. The `createCustomer` method is not silently idempotent and should not be retried.
What happens after partial failure (exceptions; no half-written silent null)?
  - After a partial failure, exceptions are thrown to indicate the failure, and no half-written or silent null values are returned. This ensures that the system maintains data integrity and provides clear feedback to the caller about the failure.
What would an operator monitor later (correlation ID, error rates)?
  - An operator would monitor correlation IDs for tracing requests, error rates to identify issues in the system, and performance metrics to ensure the service is operating efficiently. Additionally, monitoring logs for unexpected exceptions and response times would be important for maintaining service reliability.
Which local default is unacceptable in production (in-memory; System.out logging)?
  - The local default of using in-memory storage and System.out logging is unacceptable in production. In a production environment, persistent storage should be used to ensure data durability, and a proper logging framework should be implemented to manage log levels, formats, and destinations securely.
How are contracts versioned later (Lab 13+ WSDL/OpenAPI; stable method names help)?
  - Contracts are versioned using WSDL or OpenAPI specifications in later labs (Lab 13+). Stable method names and consistent API endpoints help maintain backward compatibility, allowing clients to rely on the same interface even as the underlying implementation evolves. Versioning strategies may include URL versioning, header-based versioning, or query parameter versioning to manage changes in the API contract effectively.
