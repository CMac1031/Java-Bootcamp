## lab12-001 — 2026-07-29
**Prompt used:**  
Extract the repeated customer-status conversion logic from `CustomerService`
into a focused method and update the tests to verify the behavior remains unchanged.
Use the following methods as a guide for the expected behavior:

```java
private final Map<String, Customer> customersById = new HashMap<>();

public Customer createCustomer(String customerId, String fullName, String email,
                               String phone, CustomerStatus status) { ... }

public Customer getCustomer(String customerId) { ... }

public Customer updateStatus(String customerId, CustomerStatus newStatus) { ... }

private void requireNonBlank(String value, String fieldName) { ... }
private void requireUniqueId(String customerId) { ... }
private Customer requireExisting(String customerId) { ... }

```
** Verdict **
Accept with edits

**Risk **
I accepted the extraction because it reduced duplication, but edited the invalid-status
behavior so the service does not silently accept incorrect customer data.