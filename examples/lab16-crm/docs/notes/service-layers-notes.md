Bean Validation from Lab 14 checks the shape of incoming data. For example, it rejects a blank name, an invalid email format, or a customer ID that exceeds its maximum length.

CustomerValidator checks business meaning. It prevents duplicate customer IDs and emails and determines whether a requested status transition is allowed. The API facade performs Bean Validation before calling the service, while DefaultCustomerService invokes CustomerValidator before saving changes.

PROSPECT  -> ACTIVE, CLOSED
ACTIVE    -> SUSPENDED, CLOSED
SUSPENDED -> ACTIVE, CLOSED
CLOSED    -> (none)

A same-status request is rejected. For example, ACTIVE → ACTIVE is not listed as an allowed transition and therefore throws IllegalStateException.

This decision prevents callers from treating an unchanged status as a successful business operation. A future version could deliberately make this operation idempotent, but that behavior must be explicitly added to the contract.

The validator and service receive the same repository instance. This allows duplicate checks and service operations to observe the same stored customers.

This wiring previews Spring dependency injection. A later Spring lab can create and inject these objects without changing the service interface or business rules.
