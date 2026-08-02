# AI test/refactor notes — Lab 11

## lab11-001 — generated exploratory test
- Accepted / rejected trivial assertion? Rejected as too trivial; it did not exercise meaningful behavior.
- Notes: Added a more useful test for `listAll()` immutability to verify the service returns an unmodifiable view of its internal collection.

## lab11-002 — CustomerServiceTest
- Notes: Refactored `addCustomer()` to use `findByCustomerId()` for duplicate detection, removing duplicated lookup logic and keeping behavior unchanged. Existing tests for add/duplicate still validate the contract.

## lab11-003 — CustomerNotifier extract + Mockito
- Notes: Extracted a `CustomerNotifier` abstraction and wired it into `CustomerService` via constructor injection. The default no-arg constructor uses a no-op notifier. Mockito can verify notifier calls without coupling the service to a concrete implementation.

## lab11-004 — coverage gaps / acceptance guidelines
- Notes: Coverage gaps should be documented explicitly. Acceptance criteria should include: meaningful assertions, behavior-preserving refactors, no new dependencies beyond those already present, and clear explanation of why the code is correct.